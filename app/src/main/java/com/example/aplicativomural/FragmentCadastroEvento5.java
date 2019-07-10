package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
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
    private String categoriaSelecionada;
    private Object obj=null;
    private ControllerCategoria controller = new ControllerCategoria();

    public interface FragmentCadastroEvento5Listener{
        void onClickTela5(String categoria);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_cadastro_evento_5, container,false);
        proximaTela = v.findViewById(R.id.Vai_para_fragment_6);
        categoriaSelecionada = "";
        final ListView listaCategorias = v.findViewById(R.id.Lista_categorias);

        final List list = new ArrayList<com.example.aplicativomural.Categoria>();
        controller.readCategorias(new ControllerCategoria.DataStatus() {
            @Override
            public void DataIsLoaded(List<Categoria> categorias, List<String> keys) {
                for(Categoria categoria:categorias){
                    list.add(categoria.getNome());
                }
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        /*final com.example.aplicativomural.Categoria categoria1= new com.example.aplicativomural.Categoria("Dança");
        final com.example.aplicativomural.Categoria categoria2= new com.example.aplicativomural.Categoria("Musica");
        final com.example.aplicativomural.Categoria categoria3= new com.example.aplicativomural.Categoria("Teatro");
        list.add(categoria1);
        list.add(categoria2);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);
        list.add(categoria3);*/


        CategoriaListAdapter adapter = new CategoriaListAdapter(Objects.requireNonNull(getContext()),R.layout.adapter_lista_categoria, (ArrayList<com.example.aplicativomural.Categoria>) list);
        listaCategorias.setAdapter(adapter);
        listaCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                obj = adapterView.getAdapter().getItem(i);
                com.example.aplicativomural.Categoria a = (com.example.aplicativomural.Categoria)obj;
                categoriaSelecionada = a.getNome();
            }
        });

        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(categoriaSelecionada.isEmpty()){
                    Toast.makeText(Objects.requireNonNull(getContext()),"Selecione uma categoria",Toast.LENGTH_LONG).show();
                }else{
                    cadastroEvento5Listener.onClickTela5(categoriaSelecionada);
                }
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
