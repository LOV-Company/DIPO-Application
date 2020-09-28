package com.lov.dipo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lov.dipo.R;
import com.lov.dipo.model.Property;

import java.util.ArrayList;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private ArrayList<Property> listProperty;

    public PropertyAdapter(ArrayList<Property> list) {
        this.listProperty = list;
    }

    @NonNull
    @Override
    public PropertyAdapter.PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_property_home, viewGroup, false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PropertyViewHolder holder, int position) {

        Property property =listProperty.get(position);
        Glide.with(holder.itemView.getContext())
                .load(property.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.judul.setText(property.getJudul());
        holder.jenis.setText(property.getJenis());
        holder.tipe.setText(property.getTipe());
        holder.harga.setText(property.getHarga());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PropertyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView judul, jenis, tipe, harga;
        public PropertyViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_property);
            judul = itemView.findViewById(R.id.judul);
            jenis = itemView.findViewById(R.id.jenis);
            tipe = itemView.findViewById(R.id.tipe);
            harga = itemView.findViewById(R.id.harga);
        }
    }
}
