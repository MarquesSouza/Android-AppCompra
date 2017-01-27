package com.example.marquesdesouza.appcomprafacil.model;

/**
 * Created by Marques de Souza on 27/01/2017.
 */

public class Produto {
    private String nome;
    private String codigo;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
