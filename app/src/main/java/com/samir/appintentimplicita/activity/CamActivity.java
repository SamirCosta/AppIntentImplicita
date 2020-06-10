package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.samir.appintentimplicita.R;
import com.samir.appintentimplicita.RecyclerItemClickListener;
import com.samir.appintentimplicita.ZoomActivity;
import com.samir.appintentimplicita.adapter.CamAdapter;
import com.samir.appintentimplicita.model.Imagem;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CamActivity extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private RecyclerView recyclerView;
    private List<Imagem> listaImgs = new ArrayList<>();
    private Bitmap imageBitmap;
    private CamAdapter camAdapter;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        recyclerView = findViewById(R.id.recycler);

        camAdapter = new CamAdapter(listaImgs);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(camAdapter);

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
                recyclerView.addOnItemTouchListener(
                        new RecyclerItemClickListener(
                                getApplicationContext(),
                                recyclerView,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        Imagem imagem = listaImgs.get(position);
                                        Bitmap x = imagem.getImgBit();
                                        String imgCam = BitMapToString(x);
                                        zoom(imgCam);
                                    }

                                    @Override
                                    public void onLongItemClick(View view, int position) {

                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    }
                                }
                        )
                );
                this.addImg();
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

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public void zoom(String imgZoom){
        Intent intent = new Intent(CamActivity.this, ZoomActivity.class);
        intent.putExtra("imgBit", imgZoom);
        startActivity(intent);
    }

}