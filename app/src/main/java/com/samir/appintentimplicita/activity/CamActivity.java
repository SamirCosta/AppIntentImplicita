package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.samir.appintentimplicita.R;
import com.samir.appintentimplicita.adapter.Adapter;
import com.samir.appintentimplicita.model.Imagem;

import java.util.ArrayList;
import java.util.List;

public class CamActivity extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private RecyclerView recyclerView;
    private List<Imagem> listaImgs = new ArrayList<>();
    private Bitmap imageBitmap;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        recyclerView = findViewById(R.id.recycler);

        this.addImg();

        Adapter adapter = new Adapter(listaImgs);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    public void capturarImagem(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAPTURAR_IMAGEM);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                /*ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(imageBitmap);
                LinearLayout ln = (LinearLayout)findViewById(R.id.layoutLinear);
                ln.addView(imageView);*/
                mostrarMensagem("Imagem capturada!");
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }

    }

    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG)
                .show();
    }

    public void addImg(){
        Imagem imagem = new Imagem(imageBitmap);
        this.listaImgs.add(imagem);
    }

}