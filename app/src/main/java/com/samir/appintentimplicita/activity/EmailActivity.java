package com.samir.appintentimplicita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.samir.appintentimplicita.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EmailActivity extends AppCompatActivity {
    private EditText destinatario, assunto, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        destinatario = findViewById(R.id.editDestin);
        assunto = findViewById(R.id.editAssunto);
        texto = findViewById(R.id.editTexto);

    }

    public void enviarEmail(View view) throws UnsupportedEncodingException {

        String txtDestin = destinatario.getText().toString();
        String txtAssunto = assunto.getText().toString();
        String txtTexto = texto.getText().toString();

        String uriText =
                "mailto:"+ txtDestin +
                        "?subject=" + URLEncoder.encode(txtAssunto, "utf-8") +
                        "&body=" + URLEncoder.encode(txtTexto, "utf-8");
        Uri uri = Uri.parse(uriText);
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(uri);
        startActivity(Intent.createChooser(it, "Enviar Email"));

    }

}
