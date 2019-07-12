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

import com.example.aplicativomural.models.Categoria;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentCadastroEvento5 extends Fragment {
    private ImageView proximaTela;
    private FragmentCadastroEvento5Listener cadastroEvento5Listener;
    private String categoriaSelecionada;
    private Object obj=null;
    private ControllerCategoria controller = new ControllerCategoria();
    private DatabaseReference reff;

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
        final List list = new ArrayList<Categoria>();
        reff = FirebaseDatabase.getInstance().getReference().child("categorias");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Categoria categoria1 = new Categoria();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    
                    categoria1.setNome(snapshot.getValue(Categoria.class).getNome());
                    list.add(categoria1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //System.out.println(list);
        /*final com.example.aplicativomural.models.Categoria categoria1= new com.example.aplicativomural.models.Categoria("Dança");
        final com.example.aplicativomural.models.Categoria categoria2= new com.example.aplicativomural.models.Categoria("Musica");
        final com.example.aplicativomural.models.Categoria categoria3= new com.example.aplicativomural.models.Categoria("Teatro");
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


        CategoriaListAdapter adapter = new CategoriaListAdapter(Objects.requireNonNull(getContext()),R.layout.adapter_lista_categoria, (ArrayList<Categoria>) list);
        listaCategorias.setAdapter(adapter);
        listaCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                obj = adapterView.getAdapter().getItem(i);
                Categoria a = (Categoria)obj;
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
