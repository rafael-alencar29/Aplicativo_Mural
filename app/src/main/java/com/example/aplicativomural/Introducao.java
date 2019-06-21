package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Introducao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);
        final TextView fraseinial= (TextView)findViewById(R.id.Frase_inicial);
        final Intent telainial = new Intent(Introducao.this,Introducao2.class);
        fraseinial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Introducao.this.startActivity(telainial);
            }
        });
    }
}
