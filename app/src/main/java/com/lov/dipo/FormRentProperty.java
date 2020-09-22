package com.lov.dipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FormRentProperty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_rent_property);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Form Rent Property");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}