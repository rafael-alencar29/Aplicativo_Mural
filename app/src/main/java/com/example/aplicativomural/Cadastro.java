package com.example.aplicativomural;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final Button escolha = findViewById(R.id.Escolher);
        final EditText matricula = findViewById(R.id.Matricula);
        final EditText usuario = findViewById(R.id.Usuario_login_cadastro);
        final EditText senha = findViewById(R.id.Senha_login_cadastro);
        final EditText nome = findViewById(R.id.Usuario_nome);
        final Button registrar = findViewById(R.id.registrar);

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
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((nome.getText().toString()).isEmpty() || (nome.getText().toString().length()<2)){
                    nome.setHint("Digite seu nome");
                    nome.setHintTextColor(Color.parseColor("#FF0000"));
                }else if((usuario.getText().toString()).isEmpty()){
                    usuario.setHint("Digite seu e-mail");
                    usuario.setHintTextColor(Color.parseColor("#FF0000"));
                    //Toast.makeText(Cadastro.this,"Digite e-mail", Toast.LENGTH_LONG).show();
                }else if((senha.getText().toString()).isEmpty() || (senha.getText().toString().length()<6)){
                    senha.setHint("Digite uma senha");
                    senha.setHintTextColor(Color.parseColor("#FF0000"));
                }else if(((escolha.getText().toString()).equals("Aluno") || (escolha.getText().toString()).equals("Professor")) && ((matricula.getText().toString().length()<9)||((matricula.getText().toString()).isEmpty()))){
                    Toast.makeText(Cadastro.this,"Digite sua matricula com 9 números", Toast.LENGTH_LONG).show();
                }
                //Lidar com cadastro ao banco de dados aqui
            }
        });
    }
}
