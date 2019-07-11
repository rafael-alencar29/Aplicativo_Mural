package com.example.aplicativomural;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aplicativomural.models.Categoria;

import java.util.ArrayList;
import java.util.Objects;

public class CategoriaListAdapter extends ArrayAdapter<Categoria> {
    public int mRe;
    public CategoriaListAdapter(Context context, int resource, ArrayList<Categoria> objects) {
        super(context, resource, objects);
        mRe = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String categoria = getItem(position).getNome();
        Categoria categoria1 = new Categoria();
        categoria1.setNome(categoria);
        LayoutInflater inflater = LayoutInflater.from(Objects.requireNonNull(getContext()));
        convertView = inflater.inflate(mRe, parent,false);

        TextView vCategoria = convertView.findViewById(R.id.TextviewCategoria);
        vCategoria.setText(categoria);
        return convertView;
    }
}
