package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentCadastroEvento5 extends Fragment {
    private ImageView proximaTela;
    private FragmentCadastroEvento5Listener cadastroEvento5Listener;
    private ListAdapter adapter;
    private com.example.aplicativomural.Categoria categoria;
    private String categoriaSelecionada=null;

    public interface FragmentCadastroEvento5Listener{
        void onClickTela5(String categoria);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_5, container,false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_6);
        final ListView listaCategorias = v.findViewById(R.id.Lista_categorias);

        List list = new ArrayList<com.example.aplicativomural.Categoria>();
        final com.example.aplicativomural.Categoria categoria1= new com.example.aplicativomural.Categoria("Categoria");
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);
        list.add(categoria1);

        CategoriaListAdapter adapter = new CategoriaListAdapter(Objects.requireNonNull(getContext()),R.layout.adapter_lista_categoria, (ArrayList<com.example.aplicativomural.Categoria>) list);
        listaCategorias.setAdapter(adapter);
        listaCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
            }
        });


        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroEvento5Listener.onClickTela5("A");
            }
        });
        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentCadastroEvento5Listener){
            cadastroEvento5Listener = (FragmentCadastroEvento5Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cadastroEvento5Listener=null;
    }
}
