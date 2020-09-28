package com.lov.dipo.ui.sell;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lov.dipo.R;
import com.lov.dipo.StatusProperty;
import com.lov.dipo.ui.profile.ProfileFragment;

public class SellFragment extends Fragment implements View.OnClickListener {

    private SellViewModel sellViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sellViewModel = ViewModelProviders.of(this).get(SellViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sell, container, false);
        ImageView moveToPilihStatus = root.findViewById(R.id.pilih_status_property);
        moveToPilihStatus.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        Intent move = new Intent(getActivity(), StatusProperty.class);
        startActivity(move);
    }
}