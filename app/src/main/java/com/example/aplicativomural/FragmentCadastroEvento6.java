package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCadastroEvento6 extends Fragment {
    private ImageView voltaTela;
    public FragmentCadastroEvento6Listener cadastroEvento6Listener;

    public interface FragmentCadastroEvento6Listener{
        void onClickTela6();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_6, container,false);
        voltaTela = v.findViewById(R.id.Volta_para_tela_anterior);
        voltaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroEvento6Listener.onClickTela6();
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento6Listener){
            cadastroEvento6Listener = (FragmentCadastroEvento6Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento6Listener=null;
    }
}
