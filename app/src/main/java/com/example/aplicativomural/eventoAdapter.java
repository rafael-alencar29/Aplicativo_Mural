package com.example.aplicativomural;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class eventoAdapter extends RecyclerView.Adapter<eventoAdapter.ViewHolder> {

    private ArrayList<eventos> evento;
    private OnItemListener mOnItemListener;

    public eventoAdapter(Context context, ArrayList<eventos> list, OnItemListener onItemListener) {
        evento = list;
        this.mOnItemListener = onItemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nomeEvento, qtdInteressados;
        ImageView fotoEvento;
        OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);

            nomeEvento = itemView.findViewById(R.id.NomeEv);
            qtdInteressados = itemView.findViewById(R.id.QtdPesEv);
            fotoEvento = itemView.findViewById(R.id.imagemEv);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public eventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_eventos, viewGroup, false);

        return new ViewHolder(v, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull eventoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(evento.get(i));
        viewHolder.nomeEvento.setText(evento.get(i).getTitulo());
        viewHolder.qtdInteressados.setText(evento.get(i).getInteressados());
        //viewHolder.fotoEvento.setImageResource(R.drawable.evento1);
    }

    @Override
    public int getItemCount() { return evento.size(); }
}
