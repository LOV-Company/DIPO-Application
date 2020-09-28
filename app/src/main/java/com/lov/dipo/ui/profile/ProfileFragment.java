package com.lov.dipo.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    TextView tvName;
    Button btnToLogin;
    LinearLayout profileAfterLogin;
    LinearLayout profileBeforeLogin;
    LinearLayout btnLogout;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        firebaseAuth = firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        btnToLogin = (Button) root.findViewById(R.id.moveLogin);

        tvName = (TextView) root.findViewById(R.id.tv_name);
        profileAfterLogin = (LinearLayout) root.findViewById(R.id.profile_after_login);
        profileBeforeLogin = (LinearLayout) root.findViewById(R.id.profile_before_login);

        btnLogout = (LinearLayout) root.findViewById(R.id.profile_btn_logout);


        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });


        if(firebaseUser != null){
            tvName.setText(firebaseUser.getDisplayName());
            profileAfterLogin.setVisibility(View.VISIBLE);
            profileBeforeLogin.setVisibility(View.GONE);
        }else{
            profileBeforeLogin.setVisibility(View.VISIBLE);
            profileAfterLogin.setVisibility(View.GONE);
        }

        return root;
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