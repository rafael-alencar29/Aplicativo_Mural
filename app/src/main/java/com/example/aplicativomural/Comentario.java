package com.example.aplicativomural;

public class Comentario {
    private String Descricao;
    private Integer Horario;
    private String IdUsuario;
    private String IdEvento;

    public Comentario() {
    }

    public Comentario(String descricao, Integer horario, String idUsuario, String idEvento) {
        Descricao = descricao;
        Horario = horario;
        IdUsuario = idUsuario;
        IdEvento = idEvento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Integer getHorario() {
        return Horario;
    }

    public void setHorario(Integer horario) {
        Horario = horario;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(String idEvento) {
        IdEvento = idEvento;
    }
}
