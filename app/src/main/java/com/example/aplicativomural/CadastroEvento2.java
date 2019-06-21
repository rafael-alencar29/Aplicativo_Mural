package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CadastroEvento2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento2);
        //Componentes da tela
        final Intent telaCadastro3 =  new Intent(CadastroEvento2.this,CadastroEvento3.class);
        final ImageView proximaTela = (ImageView)findViewById(R.id.Tela_3_cadastro_evento);
        //Logica da tela
        proximaTela.setOnClickListener(new View.OnClickListener() {//Chama a proxima tela
            @Override
            public void onClick(View view) {
                CadastroEvento2.this.startActivity(telaCadastro3);
            }
        });
    }
}
