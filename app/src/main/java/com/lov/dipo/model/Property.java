package com.lov.dipo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable {

    private String judul;
    private String harga;
    private String jenis;
    private String tipe;
    private String alamat;
    private String deskripsi;
    private int photo;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.harga);
        dest.writeString(this.jenis);
        dest.writeString(this.tipe);
        dest.writeString(this.alamat);
        dest.writeString(this.deskripsi);
        dest.writeInt(this.photo);
    }

    public Property() {
    }

    protected Property(Parcel in) {
        this.judul = in.readString();
        this.harga = in.readString();
        this.jenis = in.readString();
        this.tipe = in.readString();
        this.alamat = in.readString();
        this.deskripsi = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Property> CREATOR = new Parcelable.Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel source) {
            return new Property(source);
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };
}