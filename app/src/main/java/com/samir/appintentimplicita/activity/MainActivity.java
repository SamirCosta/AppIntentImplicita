package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samir.appintentimplicita.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirEmail(View view){
        Intent intent = new Intent(MainActivity.this, EmailActivity.class);
        startActivity(intent);
    }

    public void abrirEnd(View view){
        Intent intent = new Intent(MainActivity.this, EndActivity.class);
        startActivity(intent);
    }

    public void abrirTel(View view){
        Intent intent = new Intent(MainActivity.this, TelActivity.class);
        startActivity(intent);
    }

    public void abrirCam(View view){
        Intent intent = new Intent(MainActivity.this, CamActivity.class);
        startActivity(intent);
    }

    public void abrirSelGal(View view){
        Intent intent = new Intent(MainActivity.this, SelGalActivity.class);
        startActivity(intent);
    }

}
