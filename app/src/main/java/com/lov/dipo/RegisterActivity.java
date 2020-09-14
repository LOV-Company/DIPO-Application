package com.lov.dipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lov.dipo.ui.profile.ProfileFragment;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        Button moveLogin = (Button) findViewById(R.id.moveToLogin);
        moveLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}