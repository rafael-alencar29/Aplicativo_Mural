package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Introducao extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(Introducao.this,Introducao2.class);
                startActivity(welcome);

                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                finish();
            }
        },WELCOME_TIMEOUT);

    }
}
