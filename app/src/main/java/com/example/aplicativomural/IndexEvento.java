package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IndexEvento extends AppCompatActivity implements eventoAdapter.OnItemListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    private GestureDetectorCompat gestureObject;

    ImageView imageEvento;

    ArrayList<eventos> evento;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexevento);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        evento = new ArrayList<eventos>();

        myAdapter = new eventoAdapter(this, evento, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClick(int position) {
        evento.get(position);

        if(position == 0) {
            Intent intent = new Intent(this, Introducao.class); // Mudar dps
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Cadastro.class);   // Mudar dps
            startActivity(intent);
        }
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            if(event2.getX() > event1.getX()) {
                Intent intent = new Intent(IndexEvento.this, CadastroEvento1.class);
                startActivity(intent);
            }
            return true;
        }
    }
}
