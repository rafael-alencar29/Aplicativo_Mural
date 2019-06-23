package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentCadastroEvento2 extends Fragment {
    private ImageView proximaTela;
    private EditText titulo, descricao;
    public FragmentCadastroEvento2Listener cadastroEvento2Listener;

    public interface FragmentCadastroEvento2Listener{
        void onClickTela2(String titulo, String descricao);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_2, container,false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_3);
        titulo = v.findViewById(R.id.Titulo_evento);
        descricao = v.findViewById(R.id.Descricao_evento);

        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((titulo.getText().toString()).equals(null) || (titulo.getText().toString()).length() < 10){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Adicione um tilulo maior",Toast.LENGTH_LONG).show();
                }else if((descricao.getText().toString()).equals(null) || (descricao.getText().toString()).length() < 10){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Adicione uma descrição maior",Toast.LENGTH_LONG).show();
                }else {
                    cadastroEvento2Listener.onClickTela2(titulo.getText().toString(),descricao.getText().toString());
                }
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento2Listener){
            cadastroEvento2Listener = (FragmentCadastroEvento2Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento2Listener=null;
    }
}
