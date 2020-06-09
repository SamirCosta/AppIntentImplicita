package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.samir.appintentimplicita.R;
import com.samir.appintentimplicita.adapter.GalAdapter;
import com.samir.appintentimplicita.model.Imagem;
import com.samir.appintentimplicita.model.ImagemURI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelGalActivity extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private RecyclerView recyclerGal;
    private GalAdapter adapterGal;
    private List<ImagemURI> imagemss = new ArrayList<>();
    private Uri imageUri;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_gal);
        recyclerGal = findViewById(R.id.recyclerSelGal);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                imageUri = data.getData();
                adapterGal = new GalAdapter(imagemss, getApplicationContext());
                RecyclerView.LayoutManager layoutManagerGal = new GridLayoutManager(getApplicationContext(),2);
                recyclerGal.setLayoutManager(layoutManagerGal);
                recyclerGal.setHasFixedSize(true);
                recyclerGal.setAdapter(adapterGal);
                this.adicionaImg();
                mostrarMensagem("Imagem capturada!");
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }

    }

    public void selecionarGaleria(View view) {
        Intent intent =     new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), CAPTURAR_IMAGEM);
    }

    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG)
                .show();
    }

    public void adicionaImg(){
        ImagemURI imagemURI = new ImagemURI(imageUri);
        this.imagemss.add(imagemURI);
    }

}