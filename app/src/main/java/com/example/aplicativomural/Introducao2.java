package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Introducao2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao2);
        final TextView fraseinial= (TextView)findViewById(R.id.Mural);
        final Intent telainial = new Intent(Introducao2.this,MainActivity.class);
        fraseinial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Introducao2.this.startActivity(telainial);
            }
        });
    }
}
