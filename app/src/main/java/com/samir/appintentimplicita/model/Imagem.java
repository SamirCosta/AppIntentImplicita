package com.samir.appintentimplicita.model;

import android.graphics.Bitmap;

public class Imagem {
    private Bitmap imgBit;

    public Imagem(){

    }

    public Imagem(Bitmap imgBit) {
        this.imgBit = imgBit;
    }

    public Bitmap getImgBit() {
        return imgBit;
    }

    public void setImgBit(Bitmap imgBit) {
        this.imgBit = imgBit;
    }
}
