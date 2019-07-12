package com.example.aplicativomural;

import android.widget.ImageView;

public class eventos {

    private String titulo, descricao;
    private int qtd_interessados;
    private ImageView cartaz;

    public eventos(String titulo, String descricao, int qtd_interessados) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtd_interessados = qtd_interessados;
        //this.cartaz = cartaz;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtd_interessados(int qtd_interessados) {
        this.qtd_interessados = qtd_interessados;
    }

    public void setCartaz(ImageView cartaz) {
        this.cartaz = cartaz;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getInteressados() {
        return qtd_interessados;
    }

    public ImageView getCartaz() {
        return cartaz;
    }
}
