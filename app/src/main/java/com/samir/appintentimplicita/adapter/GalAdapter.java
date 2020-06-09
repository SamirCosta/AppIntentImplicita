package com.samir.appintentimplicita.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samir.appintentimplicita.R;
import com.samir.appintentimplicita.model.ImagemURI;

import java.util.List;

public class GalAdapter extends RecyclerView.Adapter<GalAdapter.MyViewHolder> {

    List<ImagemURI> imagemss;
    private Context context;
    private View item;

    public GalAdapter(List<ImagemURI> listaImg, Context c){
        this.imagemss = listaImg;
        this.context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_gal, parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ImagemURI imagemURI = imagemss.get(position);
        holder.imgView.setImageURI(imagemURI.getImgUri());
    }

    @Override
    public int getItemCount() {
        return imagemss.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;

        public MyViewHolder(View itemView){
            super(itemView);
            imgView = itemView.findViewById(R.id.imageViewGal);
        }
    }
}
