package com.example.aplicativomural.controllers;

import androidx.annotation.NonNull;

import com.example.aplicativomural.models.Usuario;
import com.google.android.gms.tasks.OnSuccessListener;
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
        void DataIsDeleted();

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
        });
    }
    public void addUsuario(Usuario usuario, final DataStatus dataStatus){
        String key = mReferenceUsuario.push().getKey();
        mReferenceUsuario.child(key).setValue(usuario)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
    }
    public void updateUsuario(String key, Usuario usuario, final DataStatus dataStatus){
        mReferenceUsuario.child(key).setValue(usuario)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }
    public void deleteUsuario(String key, final DataStatus dataStatus){
        mReferenceUsuario.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}
