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
import androidx.fragment.app.FragmentTransaction;

public class FragmentCadastroEvento4 extends Fragment {
    private ImageView proximaTela;
    public FragmentCadastroEvento4Listener cadastroEvento4Listener;

    public interface FragmentCadastroEvento4Listener{
        void onClickTela4();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_4, container,false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_5);
        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroEvento4Listener.onClickTela4();
            }
        });
        return v;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new MapaCadastroEvento();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.Layout_mapa, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento4Listener){
            cadastroEvento4Listener = (FragmentCadastroEvento4Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento4Listener=null;
    }
}
