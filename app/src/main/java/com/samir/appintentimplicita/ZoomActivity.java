package com.samir.appintentimplicita;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

public class ZoomActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        imageView = findViewById(R.id.imageViewZoom);

        try {
            Bundle bundle = getIntent().getExtras();
            String stringImgUri = bundle.getString("img");
            String stringImgBit = bundle.getString("imgBit");
            if(stringImgUri != null) {
                Uri myUri = Uri.parse(stringImgUri);
                imageView.setImageURI(myUri);
            }
            if (stringImgBit != null) {
                Bitmap ImgBit = StringToBitMap(stringImgBit);
                imageView.setImageBitmap(ImgBit);
            }
        }catch (Exception e){
            Log.i("DEU RUIM ", "AQUI"+e);
        }
    }

    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
}