package com.example.aplicativomural;

public class Usuario {
    private String Nome;
    private String Senha;
    private String Email;
    private String Matricula;
    private Boolean Administrador;
    private Boolean Tipo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public Boolean getAdministrador() {
        return Administrador;
    }

    public void setAdministrador(Boolean administrador) {
        Administrador = administrador;
    }

    public Boolean getTipo() {
        return Tipo;
    }

    public void setTipo(Boolean tipo) {
        Tipo = tipo;
    }
}
