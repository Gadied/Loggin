package com.example.loggin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.loggin.Adap.GaleryImagen;

public class GaleryFull extends AppCompatActivity {

    ImageView imagenDetalle;
    GaleryImagen galeryImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery_full);
        imagenDetalle = findViewById(R.id.img_det);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Galery full");

        Intent i = getIntent();
        int posicion = i.getExtras().getInt("idimagen");
        galeryImagen = new GaleryImagen(this);
        imagenDetalle.setImageResource(
                galeryImagen.imagenArray[posicion]
        );
    }
}