package com.samir.appintentimplicita.model;

import android.net.Uri;

public class ImagemURI {
    private Uri imgUri;

    public ImagemURI(Uri imgUri) {
        this.imgUri = imgUri;
    }

    public Uri getImgUri() {
        return imgUri;
    }

    public void setImgUri(Uri imgUri) {
        this.imgUri = imgUri;
    }
}
