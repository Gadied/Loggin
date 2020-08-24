package com.example.loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.loggin.Adap.GaleryImagen;

public class GaleriaActivity extends AppCompatActivity {
    GridView gridViewImagenes;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        gridViewImagenes=findViewById(R.id.grid_view_imagenes);
        gridViewImagenes.setAdapter(new GaleryImagen(this));

        gridViewImagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i , long l) {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            GaleryFull.class);

                    intent.putExtra("idimagen",i);
                    startActivity(intent);
                }
        });
    }
}