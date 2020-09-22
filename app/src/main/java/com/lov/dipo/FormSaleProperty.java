package com.lov.dipo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FormSaleProperty extends AppCompatActivity {

    ImageView img1;
    Button btn_img1;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_sale_property);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Form Sale Property");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        img1 = findViewById(R.id.img1);
        btn_img1 = findViewById(R.id.btn_img1);

        btn_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        // show pop up for permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {
                        // permission already granted
                        pickImageFromGallery();
                    }
                }
                else {
                    pickImageFromGallery();
                }
            }
        });

        // Spinner Sertifikat
        Spinner spinner_sertifikat = (Spinner) findViewById(R.id.spinner_sertfifikat);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pilih Jenis Sertifikat");
        categories.add("Sertifikat Hak Milik (SHM)");
        categories.add("Sertifikat Hak Guna Bangunan (SHGB)");
        categories.add("Sertifikat Hak Satuan Rumah Susun (SHSRS)");
        categories.add("Sertifikat Kepemilikan Lahan Berbentuk Girik");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_sertifikat.setAdapter(dataAdapter1);

        // Spinner Hadap
        Spinner spinner_hadap = (Spinner) findViewById(R.id.spinner_hadap);
        // Spinner Drop down elements
        List<String> hadap = new ArrayList<String>();
        hadap.add("Pilih Hadapan Property");
        hadap.add("Timur");
        hadap.add("Barat");
        hadap.add("Utara");
        hadap.add("Selatan");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hadap);
        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_hadap.setAdapter(dataAdapter2);

        // Spinner Kondisi
        Spinner spinner_kondisi = (Spinner) findViewById(R.id.spinner_kondisi);
        // Spinner Drop down elements
        List<String> kondisi = new ArrayList<String>();
        kondisi.add("Pilih Kondisi Property");
        kondisi.add("Baru");
        kondisi.add("Bekas");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kondisi);
        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_kondisi.setAdapter(dataAdapter3);

        // Spinner Keamanan
        Spinner spinner_keamanan = (Spinner) findViewById(R.id.spinner_keamanan);
        // Spinner Drop down elements
        List<String> keamanan = new ArrayList<String>();
        keamanan.add("Pilih Keamanan Property");
        keamanan.add("Ada");
        keamanan.add("Tidak Ada");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, keamanan);
        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_keamanan.setAdapter(dataAdapter4);

        // Spinner Air
        Spinner spinner_air = (Spinner) findViewById(R.id.spinner_air);
        // Spinner Drop down elements
        List<String> air = new ArrayList<String>();
        air.add("Pilih Jenis Air");
        air.add("PDAM");
        air.add("Air Sumur");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, air);
        // Drop down layout style - list view with radio button
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_air.setAdapter(dataAdapter5);

    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                }
                else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            img1.setImageURI(data.getData());
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}