package com.lov.dipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lov.dipo.ui.profile.ProfileFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        final Button backProfile = (Button) findViewById(R.id.backProfile);
        backProfile.setOnClickListener(this);

        final Button moveRegister = (Button) findViewById(R.id.moveToRegister);
        moveRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backProfile:
                Intent profile = new Intent(this, ProfileFragment.class);
                startActivity(profile);
                break;
            case R.id.moveToRegister:
                Intent move = new Intent(this, RegisterActivity.class);
                startActivity(move);
                break;
        }
    }
}