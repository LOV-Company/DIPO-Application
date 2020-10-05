package com.lov.dipo;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.lov.dipo.model.Propertys;

public class FormSaleProperty extends AppCompatActivity{

    Spinner sp_jenis_property,sp_air,sp_sertifikat,sp_kondisi,sp_keamanan,sp_hadap;
    EditText edt_judul,edt_harga,edt_alamat,edt_luas_tanah,edt_luas_bangunan,edt_listrik,edt_kmr_tidur,edt_kmr_mandi,edt_lantai;
    Button publish,chooseImg;
    ImageView img;

    StorageReference mStorageref;
    DatabaseReference databasePropertys;
    public Uri imguri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_sale_property);

        databasePropertys = FirebaseDatabase.getInstance().getReference("property");
        mStorageref = FirebaseStorage.getInstance().getReference("Images");

        edt_judul = (EditText) findViewById(R.id.et_judul);
        edt_harga = (EditText) findViewById(R.id.et_harga);
        edt_alamat = (EditText) findViewById(R.id.et_alamat);
        edt_luas_tanah = (EditText) findViewById(R.id.et_luas_tanah);
        edt_luas_bangunan = (EditText) findViewById(R.id.et_luas_bangunan);
        edt_listrik = (EditText) findViewById(R.id.et_listrik);
        edt_kmr_tidur = (EditText) findViewById(R.id.et_kamar_tidur);
        edt_kmr_mandi = (EditText) findViewById(R.id.et_kamar_mandi);
        edt_lantai = (EditText) findViewById(R.id.et_lantai);
        sp_jenis_property = (Spinner) findViewById(R.id.spinner_jenis_property);
        sp_air = (Spinner) findViewById(R.id.spinner_air);
        sp_sertifikat = (Spinner) findViewById(R.id.spinner_sertfifikat);
        sp_kondisi = (Spinner) findViewById(R.id.spinner_kondisi);
        sp_keamanan = (Spinner) findViewById(R.id.spinner_keamanan);
        sp_hadap = (Spinner) findViewById(R.id.spinner_hadap);
        publish = (Button) findViewById(R.id.publish_sale);
        chooseImg = (Button) findViewById(R.id.btn_chooseimage);
        img = (ImageView) findViewById(R.id.img_sale);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSale();
                FileUpload();
            }
        });

        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

    }

    private String getExtension (Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void addSale(){
        String judul = edt_judul.getText().toString().trim();
        double harga = Double.parseDouble(edt_harga.getText().toString().trim());
        String alamat = edt_alamat.getText().toString().trim();
        int luas_tanah = Integer.parseInt(edt_luas_tanah.getText().toString().trim());
        int luas_bangunan = Integer.parseInt(edt_luas_bangunan.getText().toString().trim());
        int listrik = Integer.parseInt(edt_listrik.getText().toString().trim());
        int jml_kmr_tidur = Integer.parseInt(edt_kmr_tidur.getText().toString().trim());
        int jml_kmr_mandi = Integer.parseInt(edt_kmr_mandi.getText().toString().trim());
        int jml_lantai = Integer.parseInt(edt_lantai.getText().toString().trim());
        String jenis_property = sp_jenis_property.getSelectedItem().toString();
        String air = sp_air.getSelectedItem().toString();
        String sertifikat = sp_sertifikat.getSelectedItem().toString();
        String kondisi = sp_kondisi.getSelectedItem().toString();
        String keamanan = sp_keamanan.getSelectedItem().toString();
        String hadap = sp_hadap.getSelectedItem().toString();

        if(!TextUtils.isEmpty(judul)){
            String id = databasePropertys.push().getKey();

            Propertys propertys = new Propertys(id,judul,harga,alamat,luas_tanah,luas_bangunan,listrik,jml_kmr_tidur,jml_kmr_mandi,jml_lantai,jenis_property,air,sertifikat,kondisi,keamanan,hadap);

            databasePropertys.child(id).setValue(propertys);

            Toast.makeText(this, "Property Sale Added", Toast.LENGTH_LONG).show();
        }

    }
    private void Filechooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    private void FileUpload(){
        StorageReference ref = mStorageref.child(System.currentTimeMillis() + "." + getExtension(imguri));

        ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                       // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(FormSaleProperty.this, "Image Upload Succesfully", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            imguri = data.getData();
            img.setImageURI(imguri);
        }
    }
}