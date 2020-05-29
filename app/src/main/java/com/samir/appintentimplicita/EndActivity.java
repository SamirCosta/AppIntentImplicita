package com.samir.appintentimplicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EndActivity extends AppCompatActivity {
    private EditText end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        end = findViewById(R.id.editEnd);
    }

    public void abrirMapa(View view)
    {
        String txtEnd = end.getText().toString();
        Uri location= Uri.parse("geo:0,0?q=" + txtEnd);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent );

    }

}
