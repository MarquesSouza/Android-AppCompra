package com.example.marquesdesouza.appcomprafacil.model;

import java.io.Serializable;

/**
 * Created by Marques de Souza on 27/01/2017.
 */

public class Produto implements Serializable {
    private String nome;
    private String codigo;
    private String numero;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    // codigo de serieble do frequencia rever se vai ser ultio @Override
   // public String toString(){return getMatricula()+"-"+getNome();}
}
