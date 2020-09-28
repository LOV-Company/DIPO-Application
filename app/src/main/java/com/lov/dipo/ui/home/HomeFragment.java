package com.lov.dipo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.lov.dipo.DetailPropertyActivity;
import com.lov.dipo.LoginActivity;
import com.lov.dipo.R;
import com.lov.dipo.adapter.PropertyAdapter;
import com.lov.dipo.data.PropertyData;
import com.lov.dipo.model.Property;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

//    private RecyclerView rv_properties;
//    private ArrayList<Property> list = new ArrayList<>();
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        CardView property = root.findViewById(R.id.property);
        property.setOnClickListener(this);
//        list.addAll(PropertyData.getListData());
//        rv_properties = root.findViewById(R.id.rv_properties);
//        rv_properties.setHasFixedSize(true);
//
//        rv_properties.setLayoutManager(new LinearLayoutManager(root.getContext()));
//        PropertyAdapter propertyAdapter = new PropertyAdapter(list);
//        rv_properties.setAdapter(propertyAdapter);

//        Script untuk Set displayName
//        firebaseAuth = firebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName("Fadillah").build();
//
//        firebaseUser.updateProfile(profileUpdates);
        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DetailPropertyActivity.class);
        startActivity(intent);
    }

//    private void showRecyclerList() {
//        rv_properties.setLayoutManager(HomeFragment.this);
//        PropertyAdapter propertyAdapter = new PropertyAdapter(list);
//        rv_properties.setAdapter(propertyAdapter);
//    }

}