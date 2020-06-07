package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.samir.appintentimplicita.R;

public class SelGalActivity extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_gal);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imagemSelecionada = data.getData();
                ImageView imageView = new ImageView(this);
                imageView.setImageURI(imagemSelecionada);
                LinearLayout ln = (LinearLayout)findViewById(R.id.layoutLinear);
                ln.addView(imageView);
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

}