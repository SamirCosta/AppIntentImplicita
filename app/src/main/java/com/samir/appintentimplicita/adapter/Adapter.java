package com.samir.appintentimplicita.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samir.appintentimplicita.R;
import com.samir.appintentimplicita.model.Imagem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Imagem> listaImgs;

    public Adapter(List<Imagem> lista) {
        this.listaImgs = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Imagem img = listaImgs.get(position);
        holder.img.setImageBitmap(img.getImgBit());
    }

    @Override
    public int getItemCount() {
        return listaImgs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);

        }
    }
}
