package com.lov.dipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lov.dipo.ui.profile.ProfileFragment;

public class StatusProperty extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_property);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CardView formSale = findViewById(R.id.moveToFormSale);
        formSale.setOnClickListener(this);

        CardView formRent = findViewById(R.id.moveToFormRent);
        formRent.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moveToFormSale:
                Intent sale = new Intent(this, FormSaleProperty.class);
                startActivity(sale);
                break;
            case R.id.moveToFormRent:
                Intent rent = new Intent(this, FormRentProperty.class);
                startActivity(rent);
                break;
        }
    }
}