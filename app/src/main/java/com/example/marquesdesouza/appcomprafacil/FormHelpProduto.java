package com.example.marquesdesouza.appcomprafacil;

import android.widget.EditText;
import android.widget.Spinner;

import com.example.marquesdesouza.appcomprafacil.model.Produto;

/**
 * Created by Marques de Souza on 29/01/2017.
 */

public class FormHelpProduto {
    private EditText campoNome;
    private EditText campoCodigo;
    private Spinner campoNumero;
    private Produto produto;

    public FormHelpProduto(FormProdutoActivity activity){
        campoNome=(EditText) activity.findViewById(R.id.Edt_nome);
        campoCodigo=(EditText) activity.findViewById(R.id.Edt_codigo);
        campoNumero=(Spinner) activity.findViewById(R.id.spn_produto);
        //aqui tem que arrumar o spiner pra fazer consulta e montar o numero da prateleira
    }
    public Produto pegaProduto(){
        produto.setNome(campoNome.getText().toString());
        produto.setCodigo(campoCodigo.getText().toString());
        //produto.setNumero(); ver esse caso pra como vai pergar o dado do spinner
        return produto;
    }
    public void preencheFormulario(Produto produto){
        campoNome.setText(produto.getNome());
        campoCodigo.setText(produto.getCodigo());
        this.produto=produto;
    }
}
