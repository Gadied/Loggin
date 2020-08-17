package com.example.loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loggin.Fragments.MainFragment;

public class MainActivity2 extends AppCompatActivity {
        public static final String nombres="names";
        TextView txtBienvenido;
        Button btnentrar;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            txtBienvenido=(TextView)findViewById(R.id.txtbienvenido);
            String usuario=getIntent().getStringExtra("names");
            txtBienvenido.setText("¡Bienvenido "+ usuario + "!");

            btnentrar=(Button) findViewById(R.id.btnent);

            btnentrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity2.this, com.example.loggin.Interfaces.MainActivity.class));
                }
            });

        }
}