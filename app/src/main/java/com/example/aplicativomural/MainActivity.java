package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botoes e outros componentes
        final TextView registrar = (TextView)findViewById(R.id.registrar);
        final Intent cadastro = new Intent(MainActivity.this, Cadastro.class);
        final Intent eventos = new Intent(MainActivity.this, CadastroEvento1.class);
        final EditText usuario = findViewById(R.id.Usuario_login);
        final EditText senha = findViewById(R.id.Senha_login);

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
                if((usuario.getText().toString()).isEmpty()){
                    usuario.setHint("Digite seu usuário");
                    usuario.setHintTextColor(Color.parseColor("#FF0000"));
                }else if((senha.getText().toString()).isEmpty()){
                    senha.setHint("Digite sua senha");
                    senha.setHintTextColor(Color.parseColor("#FF0000"));
                }
                //Lidar com o autenticação de usuário aqui
                MainActivity.this.startActivity(eventos);
            }
        });
    }
}
