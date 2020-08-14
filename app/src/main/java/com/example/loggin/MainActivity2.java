package com.example.loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
        public static final String nombres="names";
        TextView txtBienvenido;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            txtBienvenido=(TextView)findViewById(R.id.txtbienvenido);
            String usuario=getIntent().getStringExtra("names");
            txtBienvenido.setText("¡Bienvenido "+ usuario + "!");
        }

}