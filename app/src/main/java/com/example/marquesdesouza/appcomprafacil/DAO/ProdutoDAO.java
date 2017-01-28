package com.example.marquesdesouza.appcomprafacil.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.marquesdesouza.appcomprafacil.model.Produto;
import com.example.marquesdesouza.appcomprafacil.model.Usuario;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Marques de Souza on 27/01/2017.
 */

public class ProdutoDAO extends SQLiteOpenHelper{
    public ProdutoDAO(Context context){ super(context,"Produto",null,1);}
    private static final String NOME="nome";
    private static final String CODIGO="codigo";
    private static final String NUMERO="numero";
    private static final String TABELA="PRODUDOS";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PRODUTOS (nome TEXT NOT NULL,codigo TEXT NOT NULL,NUMERO TEXT NOT NULL);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }
    public void insere(Produto produto){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesProduto(produto);
        db.insert(TABELA,null,dados);
    }
    @NonNull
    private ContentValues getContentValuesProduto(Produto produto) {
        ContentValues dados = new ContentValues();
        dados.put(NOME, produto.getNome());
        dados.put(CODIGO, produto.getCodigo());
        dados.put(NUMERO,produto.getNumero());
        return dados;
    }
    public List<Produto> busca(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM "+TABELA+";";
        Cursor c = db.rawQuery(sql, null);

        List<Produto> produtos = new ArrayList<Produto>();
        while (c.moveToNext()) {
            Produto produto = new Produto();
            produto.setNome(c.getString(c.getColumnIndex(NOME)));
            produto.setCodigo(c.getString(c.getColumnIndex(CODIGO)));
            produto.setNumero(c.getString(c.getColumnIndex(NUMERO)));
            produtos.add(produto);
        }
        c.close();
        return produtos;
    }
    public void deleta(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {produto.getCodigo()};
        db.delete(TABELA, CODIGO+" = ?", params);
    }
    public void limpar() {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {"remover"};
        db.delete(TABELA, "'remover' = ?", params);
    }
    public void altera(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValuesProduto(produto);
        String[] params = {produto.getCodigo()};
        db.update(TABELA, dados, CODIGO +"= ?", params);
    }

}
