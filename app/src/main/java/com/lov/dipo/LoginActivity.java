package com.lov.dipo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lov.dipo.abs.BaseActivity;
import com.lov.dipo.model.Account;
import com.lov.dipo.ui.profile.ProfileFragment;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    ImageView btnBackProfile;
    Button btnToRegister;
    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnLoginWithGoogle;

    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        findViews();
        initViews();
        initListeners();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void findViews() {
        btnBackProfile = (ImageView) findViewById(R.id.backProfile);
        btnToRegister = (Button) findViewById(R.id.login_btn_to_register);
        etEmail = (EditText) findViewById(R.id.login_et_email);
        etPassword = (EditText) findViewById(R.id.login_et_password);
        btnLogin = (Button) findViewById(R.id.login_btn_login);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListeners() {
        btnBackProfile.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnToRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backProfile:
                Intent profile = new Intent(this, ProfileFragment.class);
                startActivity(profile);
                break;
            case R.id.login_btn_to_register:
                Intent move = new Intent(this, RegisterActivity.class);
                startActivity(move);
                break;
            case R.id.login_btn_login:
                signIn();
                break;
        }
    }

    private void signIn() {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());
                        //hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(LoginActivity.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //fungsi dipanggil ketika proses Authentikasi berhasil
    private void onAuthSuccess(FirebaseUser user) {
//        String username = etEmail.getText().toString();
//        String telp = etPassword.getText().toString();
//
//        writeNewUser(user.getUid(), username, user.getEmail(), telp);
        // Go to MainActivity
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    //fungsi untuk memvalidasi EditText email dan password agar tak kosong dan sesuai format
    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(etEmail.getText().toString())) {
            etEmail.setError("Required");
            result = false;
        } else {
            etEmail.setError(null);
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Required");
            result = false;
        } else {
            etPassword.setError(null);
        }

        return result;
    }

//    private void writeNewUser(String userId, String name, String email, String telp){
//        Account user = new Account(name, email, telp);
//
//        mDatabase.child("users").child(userId).setValue(user);
//    }
}