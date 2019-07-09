package com.example.aplicativomural.controllers;

import androidx.annotation.NonNull;

import com.example.aplicativomural.models.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceUsuario;
    private List<Usuario> usuarios = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Usuario> usuarios, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDelted();

    }

    public ControllerUsuario() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceUsuario = mDatabase.getReference("usuarios");
    }

    public void readUsuarios(final DataStatus dataStatus){
        mReferenceUsuario.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usuarios.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Usuario usuario = keyNode.getValue(Usuario.class);
                    usuarios.add(usuario);
                }
                dataStatus.DataIsLoaded(usuarios, keys);
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })
    }
}
