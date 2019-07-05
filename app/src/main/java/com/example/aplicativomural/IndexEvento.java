package com.example.aplicativomural;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class IndexEvento extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_evento);

        final CardView C_evento1 = findViewById(R.id.CardEvento1);
        final CardView C_evento2 = findViewById(R.id.CardEvento2);
        final CardView C_evento3 = findViewById(R.id.CardEvento3);
        final ImageView btnCadastro = findViewById(R.id.btnMapa);

        final Intent evento1 = new Intent(IndexEvento.this, Evento1.class);
        final Intent evento2 = new Intent(IndexEvento.this, Evento2.class);
        final Intent evento3 = new Intent(IndexEvento.this, Evento3.class);
        final Intent cadastro = new Intent(IndexEvento.this, CadastroEvento1.class);

        C_evento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndexEvento.this.startActivity(evento1);
            }
        });

        C_evento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndexEvento.this.startActivity(evento2);
            }
        });

        C_evento3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndexEvento.this.startActivity(evento3);
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndexEvento.this.startActivity(cadastro);
            }
        });
    }
}
