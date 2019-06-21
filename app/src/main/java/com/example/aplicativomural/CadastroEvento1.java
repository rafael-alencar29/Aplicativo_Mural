package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CadastroEvento1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento1);

        final ImageView proximatela= (ImageView)findViewById(R.id.Tela_2_cadastro_evento);
        final Intent cadastroEvento2 = new Intent(CadastroEvento1.this,CadastroEvento2.class);

        proximatela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroEvento1.this.startActivity(cadastroEvento2);
            }
        });
    }
}
