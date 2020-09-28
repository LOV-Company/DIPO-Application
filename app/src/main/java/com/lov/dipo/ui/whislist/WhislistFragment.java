package com.lov.dipo.ui.whislist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lov.dipo.R;

public class WhislistFragment extends Fragment {

    private WhislistViewModel whislistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        whislistViewModel = ViewModelProviders.of(this).get(WhislistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_whislist, container, false);
        return root;
    }
}