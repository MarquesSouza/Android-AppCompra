package com.example.marquesdesouza.appcomprafacil.model;

import java.io.Serializable;

/**
 * Created by Marques de Souza on 27/01/2017.
 */

public class Prateleira implements Serializable{
    private String numero;
    private String nome;
    private String local;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
     @Override
     public String toString(){return getNumero()+"-"+getNome();}
}
