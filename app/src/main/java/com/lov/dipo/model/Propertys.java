package com.lov.dipo.model;

public class Propertys {

    String propertyId;
    String judul;
    double harga;
    String alamat;
    int luas_tanah;
    int luas_bangunan;
    int listrik;
    int jml_kamar_tidur;
    int jml_kamar_mandi;
    int jml_lantai;
    String jenis_property;
    String air;
    String sertifikat;
    String kondisi;
    String keamanan;
    String hadap;

    public Propertys() {

    }

    public Propertys(String propertyId, String judul, double harga, String alamat, int luas_tanah, int luas_bangunan, int listrik, int jml_kamar_tidur, int jml_kamar_mandi, int jml_lantai, String jenis_property, String air, String sertifikat, String kondisi, String keamanan, String hadap) {
        this.propertyId = propertyId;
        this.judul = judul;
        this.harga = harga;
        this.alamat = alamat;
        this.luas_tanah = luas_tanah;
        this.luas_bangunan = luas_bangunan;
        this.listrik = listrik;
        this.jml_kamar_tidur = jml_kamar_tidur;
        this.jml_kamar_mandi = jml_kamar_mandi;
        this.jml_lantai = jml_lantai;
        this.jenis_property = jenis_property;
        this.air = air;
        this.sertifikat = sertifikat;
        this.kondisi = kondisi;
        this.keamanan = keamanan;
        this.hadap = hadap;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getJudul() {
        return judul;
    }

    public double getHarga() {
        return harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getLuas_tanah() {
        return luas_tanah;
    }

    public int getLuas_bangunan() {
        return luas_bangunan;
    }

    public int getListrik() {
        return listrik;
    }

    public int getJml_kamar_tidur() {
        return jml_kamar_tidur;
    }

    public int getJml_kamar_mandi() {
        return jml_kamar_mandi;
    }

    public int getJml_lantai() {
        return jml_lantai;
    }

    public String getJenis_property() {
        return jenis_property;
    }

    public String getAir() {
        return air;
    }

    public String getSertifikat() {
        return sertifikat;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getKeamanan() {
        return keamanan;
    }

    public String getHadap() {
        return hadap;
    }
}
