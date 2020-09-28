package com.lov.dipo.data;

import com.lov.dipo.R;
import com.lov.dipo.model.Property;

import java.util.ArrayList;

public class PropertyData {

    private static String[] propertiesTitles = {
            "Rumah di Antapani Bandung",
            "Rumah di Cibiru Jakarta",
            "Rumah di Kota Baru Parahyangan",
            "Rumah di Surabaya Jawa Timur",
            "Rumah di Samarinda Kalimantan"
    };

    private static String[] propertiesHarga = {
            "Rp 1.000.000.000",
            "Rp 2.000.000.000",
            "Rp 3.000.000.000",
            "Rp 4.000.000.000",
            "Rp 5.000.000.000"
    };

    private static String[] propertiesJenis = {
            "Rumah",
            "Tanah",
            "Apartemen",
            "Rumah",
            "Rumah"
    };

    private static String[] propertiesTipe = {
            "Dijual",
            "Disewa",
            "Dijual",
            "Disewa",
            "Dijual"
    };

    private static String[] propertiesAlamat = {
            "Jalan Antapani Bandung",
            "Jalan Cibiru Jakarta",
            "Jalan Kota Baru Parahyangan",
            "Jalan Surabaya Jawa Timur",
            "Jalan Samarinda Kalimantan"
    };

    private static String[] propertiesDescriptions = {
            "Properti menunjukkan kepada sesuatu yang biasanya dikenal sebagai entitas dalam kaitannya dengan kepemilikan seseorang atau sekelompok orang atas suatu hak eksklusif. Bentuk yang utama dari properti ini adalah termasuk real property, kekayaan pribadi, dan kekayaan intelektual.",
            "Properti menunjukkan kepada sesuatu yang biasanya dikenal sebagai entitas dalam kaitannya dengan kepemilikan seseorang atau sekelompok orang atas suatu hak eksklusif. Bentuk yang utama dari properti ini adalah termasuk real property, kekayaan pribadi, dan kekayaan intelektual.",
            "Properti menunjukkan kepada sesuatu yang biasanya dikenal sebagai entitas dalam kaitannya dengan kepemilikan seseorang atau sekelompok orang atas suatu hak eksklusif. Bentuk yang utama dari properti ini adalah termasuk real property, kekayaan pribadi, dan kekayaan intelektual.",
            "Properti menunjukkan kepada sesuatu yang biasanya dikenal sebagai entitas dalam kaitannya dengan kepemilikan seseorang atau sekelompok orang atas suatu hak eksklusif. Bentuk yang utama dari properti ini adalah termasuk real property, kekayaan pribadi, dan kekayaan intelektual.",
            "Properti menunjukkan kepada sesuatu yang biasanya dikenal sebagai entitas dalam kaitannya dengan kepemilikan seseorang atau sekelompok orang atas suatu hak eksklusif. Bentuk yang utama dari properti ini adalah termasuk real property, kekayaan pribadi, dan kekayaan intelektual."
    };

    private static int[] propertiesImages = {
            R.drawable.ruang1,
            R.drawable.ruang2,
            R.drawable.ruang3,
            R.drawable.ruang4,
            R.drawable.ruang5
    };

    public static ArrayList<Property> getListData() {
        ArrayList<Property> list = new ArrayList<>();
        for (int position = 0; position < propertiesTitles.length; position++) {
            Property property = new Property();
            property.setJudul(propertiesTitles[position]);
            property.setHarga(propertiesHarga[position]);
            property.setJenis(propertiesJenis[position]);
            property.setTipe(propertiesTipe[position]);
            property.setAlamat(propertiesAlamat[position]);
            property.setDeskripsi(propertiesDescriptions[position]);
            property.setPhoto(propertiesImages[position]);
            list.add(property);
        }
        return list;
    }

}
