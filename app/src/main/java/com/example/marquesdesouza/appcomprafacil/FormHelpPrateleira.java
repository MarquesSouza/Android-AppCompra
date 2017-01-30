package com.example.marquesdesouza.appcomprafacil;

import android.widget.EditText;

import com.example.marquesdesouza.appcomprafacil.model.Prateleira;

/**
 * Created by Marques de Souza on 29/01/2017.
 */

public class FormHelpPrateleira {
    private EditText campoNome;
    private EditText campoNumero;
    private EditText campoLocalizacao;
    private Prateleira prateleira;

    public FormHelpPrateleira (FormPrateleriaActivity activity){
        campoNome=(EditText) activity.findViewById(R.id.Edt_NomePrateleira);
        campoNumero=(EditText) activity.findViewById(R.id.Edt_NumeroPrateleria);
        campoLocalizacao=(EditText) activity.findViewById(R.id.Edt_NumeroPrateleria);
        prateleira =new Prateleira();
    }
    public Prateleira pegaPrateleria(){
        prateleira.setNome(campoNome.getText().toString());
        prateleira.setNumero(campoNumero.getText().toString());
        prateleira.setLocal(campoLocalizacao.getText().toString());
        return prateleira;
    }
    public void preencherFormulario(Prateleira prateleira){
        campoNome.setText(prateleira.getNome());
        campoNumero.setText(prateleira.getNumero());
        campoLocalizacao.setText(prateleira.getLocal());
        this.prateleira=prateleira;
    }
}
