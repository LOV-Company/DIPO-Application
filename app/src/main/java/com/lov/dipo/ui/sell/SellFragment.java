package com.lov.dipo.ui.sell;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lov.dipo.R;

public class SellFragment extends Fragment implements View.OnClickListener {

    private SellViewModel sellViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sellViewModel = ViewModelProviders.of(this).get(SellViewModel.class);
        View root = inflater.inflate(R.layout.fragment_publish, container, false);
//        ImageView moveToPilihStatus = root.findViewById(R.id.pilih_status_property);
//        moveToPilihStatus.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
//        Intent move = new Intent(getActivity(), StatusProperty.class);
//        startActivity(move);
    }
}