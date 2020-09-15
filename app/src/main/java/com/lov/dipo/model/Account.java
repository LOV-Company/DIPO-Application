package com.lov.dipo.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Account {
    public String username;
    public String email;
    public String telp;

    public Account() {

    }

    public Account(String username, String email, String telp) {
        this.username = username;
        this.email = email;
        this.telp = telp;
    }
}
