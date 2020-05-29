package com.samir.appintentimplicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelActivity extends AppCompatActivity {
    private EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);
        tel = findViewById(R.id.editTel);
    }

    public void abrirTel(View view)
    {
        String txtNum = tel.getText().toString();
        Uri uri = Uri.parse("tel:" + txtNum);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }

}
