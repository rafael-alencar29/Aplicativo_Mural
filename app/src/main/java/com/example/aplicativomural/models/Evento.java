package com.example.aplicativomural.models;

import java.util.Date;

public class Evento {
    private String titulo;
    private Date data;
    private String local;
    private String descricao;
    private Integer horario;
    private String IdCategoria;
    private Integer telefone;
    private String email;
    private Boolean reportado;
    private Integer whatsapp;
    private Integer telegram;
    private Boolean periodico;

    public Evento() {
    }

    public Evento(String titulo, Date data, String local, String descricao, Integer horario, String idCategoria, Integer telefone, String email, Boolean reportado, Integer whatsapp, Integer telegram, Boolean periodico) {
        this.titulo = titulo;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
        this.horario = horario;
        this.IdCategoria = idCategoria;
        this.telefone = telefone;
        this.email = email;
        this.reportado = reportado;
        this.whatsapp = whatsapp;
        this.telegram = telegram;
        this.periodico = periodico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getHorario() {
        return horario;
    }

    public void setHorario(Integer horario) {
        this.horario = horario;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        IdCategoria = idCategoria;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReportado() {
        return reportado;
    }

    public void setReportado(Boolean reportado) {
        this.reportado = reportado;
    }

    public Integer getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Integer whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Integer getTelegram() {
        return telegram;
    }

    public void setTelegram(Integer telegram) {
        this.telegram = telegram;
    }

    public Boolean getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Boolean periodico) {
        this.periodico = periodico;
    }
}
