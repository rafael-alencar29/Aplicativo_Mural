package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botoes e outros componentes
        final TextView registrar = (TextView)findViewById(R.id.registrar);
        final Intent cadastro = new Intent(MainActivity.this, Cadastro.class);
        final Intent cadastro2 = new Intent(MainActivity.this, CadastroEvento1.class);
        final Button entrar = (Button)findViewById(R.id.Entrar);
        //Backend
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(cadastro);
            }
        });
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(cadastro2);
            }
        });
    }
}
