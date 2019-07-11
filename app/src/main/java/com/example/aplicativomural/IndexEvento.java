package com.example.aplicativomural;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IndexEvento extends AppCompatActivity implements eventoAdapter.OnItemListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ImageView imageEvento;

    ArrayList<eventos> evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexevento);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //evento = new ArrayList<eventos>();

        //myAdapter = new eventoAdapter(this, evento, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClick(int position) {
        //evento.get(position);

        if(position == 0) {
            Intent intent = new Intent(this, Introducao.class); // Mudar dps
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Cadastro.class);   // Mudar dps
            startActivity(intent);
        }
    }
}
