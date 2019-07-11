package com.example.aplicativomural;

import androidx.annotation.NonNull;

import com.example.aplicativomural.models.Categoria;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ControllerCategoria {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCategoria;
    private List<Categoria> categorias = new ArrayList<>();


    public interface DataStatus{
        void DataIsLoaded(List<Categoria> categorias, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();

    }

    public ControllerCategoria() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceCategoria = mDatabase.getReference("categorias");
    }

    public void readCategorias(final DataStatus dataStatus){
        mReferenceCategoria.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                categorias.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Categoria categoria = keyNode.getValue(Categoria.class);
                    categorias.add(categoria);
                }
                dataStatus.DataIsLoaded(categorias, keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addCategoria(Categoria categoria, final DataStatus dataStatus){
        String key = mReferenceCategoria.push().getKey();
        mReferenceCategoria.child(key).setValue(categoria)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
    }
    public void updateCategoria(String key, Categoria categoria, final DataStatus dataStatus){
        mReferenceCategoria.child(key).setValue(categoria)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }
    public void deleteCategoria(String key, final DataStatus dataStatus){
        mReferenceCategoria.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}
