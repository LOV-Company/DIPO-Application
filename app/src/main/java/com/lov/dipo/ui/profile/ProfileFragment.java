package com.lov.dipo.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.lov.dipo.LoginActivity;
import com.lov.dipo.MainActivity;
import com.lov.dipo.R;
import com.lov.dipo.SplashScreen;
import com.lov.dipo.ui.home.HomeFragment;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ProfileViewModel profileViewModel;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    TextView tvName;
    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        firebaseAuth = firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        button = (Button) root.findViewById(R.id.moveLogin);
        button.setOnClickListener(this);

        tvName = (TextView) root.findViewById(R.id.tv_name);

        if(firebaseUser != null){
            button.setText("Logout");
            tvName.setText(firebaseUser.getDisplayName());
        }else{
            button.setText("Login");
            tvName.setText("Maaf Anda Belum Login");
        }

        return root;
    }

    @Override
    public void onClick(View v) {
        if(firebaseUser != null){
            signOut();
        }else{
            toLogin();
        }

    }

    void toLogin(){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
    void signOut(){
        firebaseAuth.signOut();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }


}