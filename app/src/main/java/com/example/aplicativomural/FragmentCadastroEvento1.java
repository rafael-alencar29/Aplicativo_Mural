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

public class FragmentCadastroEvento1 extends Fragment {
    private ImageView proximaTela, telaAnterior;
    public FragmentCadastroEventoListener listener;
    public Fragment proximoFragment;
    public int PROXIMA_TELA=1;

    public interface FragmentCadastroEventoListener{
        void onClickProximaTela(int A);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_1, container,false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_2);
        telaAnterior = v.findViewById(R.id.Anterior);
        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickProximaTela(PROXIMA_TELA);
            }
        });
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEventoListener){
            listener = (FragmentCadastroEventoListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}