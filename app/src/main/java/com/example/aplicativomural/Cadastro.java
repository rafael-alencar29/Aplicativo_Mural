package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class Cadastro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final Button escolha = (Button)findViewById(R.id.Escolher);
        final EditText matricula = (EditText)findViewById(R.id.Matricula);

        escolha.setText("Aluno");
        escolha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(Cadastro.this,escolha);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        escolha.setText(menuItem.getTitle());
                        if(escolha.getText().equals("Comunidade")){
                            matricula.setVisibility(View.GONE);
                        }else{
                            matricula.setVisibility(View.VISIBLE);
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
