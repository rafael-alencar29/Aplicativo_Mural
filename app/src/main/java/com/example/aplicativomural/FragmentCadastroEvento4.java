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

public class FragmentCadastroEvento4 extends Fragment{
    private ImageView proximaTela;
    private EditText end;
    private String endereco="";
    public FragmentCadastroEvento4Listener cadastroEvento4Listener;

    public interface FragmentCadastroEvento4Listener {
        void onClickTela4(String endereco);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_4, container, false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_5);
        end = v.findViewById(R.id.endereco_evento);
        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endereco = end.getText().toString();
                if(endereco.isEmpty()){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Digite o endereço!",Toast.LENGTH_LONG).show();
                }else {
                    cadastroEvento4Listener.onClickTela4(endereco);
                }
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCadastroEvento4Listener) {
            cadastroEvento4Listener = (FragmentCadastroEvento4Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento4Listener = null;
    }

}
