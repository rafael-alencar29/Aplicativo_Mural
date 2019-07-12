package com.example.aplicativomural.models;

import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Evento {
    private String tituloEvento,descricaoEvento, categoriaEvento,dataEvento,numeroTelefone,enderecoEvento;
    private boolean temWhatsapp,temTelegram;
    private Uri imagemEvento;
    private int horaEvento,minutoEvento;
    private DatabaseReference reff;


    public Evento(String tituloEvento, String descricaoEvento, String categoriaEvento, String dataEvento, String numeroTelefone, String enderecoEvento, boolean temWhatsapp, boolean temTelegram, Uri imagemEvento, int horaEvento, int minutoEvento) {
        this.tituloEvento = tituloEvento;
        this.descricaoEvento = descricaoEvento;
        this.categoriaEvento = categoriaEvento;
        this.dataEvento = dataEvento;
        this.numeroTelefone = numeroTelefone;
        this.enderecoEvento = enderecoEvento;
        this.temWhatsapp = temWhatsapp;
        this.temTelegram = temTelegram;
        this.imagemEvento = imagemEvento;
        this.horaEvento = horaEvento;
        this.minutoEvento = minutoEvento;
    }

    public void writeEvento(String tituloEvento, String descricaoEvento, String categoriaEvento, String dataEvento, String numeroTelefone, String enderecoEvento, boolean temWhatsapp, boolean temTelegram, Uri imagemEvento, int horaEvento, int minutoEvento){
        Evento evento = new Evento(tituloEvento,descricaoEvento, categoriaEvento,dataEvento,numeroTelefone,enderecoEvento,temWhatsapp,temTelegram,imagemEvento,horaEvento,minutoEvento);
        reff = FirebaseDatabase.getInstance().getReference();
        reff.getDatabase().getReference().setValue(evento);
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(String categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEnderecoEvento() {
        return enderecoEvento;
    }

    public void setEnderecoEvento(String enderecoEvento) {
        this.enderecoEvento = enderecoEvento;
    }

    public boolean isTemWhatsapp() {
        return temWhatsapp;
    }

    public void setTemWhatsapp(boolean temWhatsapp) {
        this.temWhatsapp = temWhatsapp;
    }

    public boolean isTemTelegram() {
        return temTelegram;
    }

    public void setTemTelegram(boolean temTelegram) {
        this.temTelegram = temTelegram;
    }

    public Uri getImagemEvento() {
        return imagemEvento;
    }

    public void setImagemEvento(Uri imagemEvento) {
        this.imagemEvento = imagemEvento;
    }

    public int getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(int horaEvento) {
        this.horaEvento = horaEvento;
    }

    public int getMinutoEvento() {
        return minutoEvento;
    }

    public void setMinutoEvento(int minutoEvento) {
        this.minutoEvento = minutoEvento;
    }
}
