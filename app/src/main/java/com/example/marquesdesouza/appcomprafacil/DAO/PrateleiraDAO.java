package com.example.marquesdesouza.appcomprafacil.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.marquesdesouza.appcomprafacil.model.Prateleira;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marques de Souza on 28/01/2017.
 */

public class PrateleiraDAO extends SQLiteOpenHelper {
        public PrateleiraDO (Context context){ super(context,"Prateleira",null,1);}
        private static final String TABELA="Prateleira";
        private static final String NUMERO="numero";
        private static final String NOME="nome";
        private static final String LOCAL="local";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Prateleira (nome TEXT NOT NULL,numero TEXT NOT NULL,local TEXT NOT NULL);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }
    public void insere(Prateleira prateleira){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesPrateleira(prateleira);
        db.insert(TABELA,null,dados);
    }
    @NonNull
    private ContentValues getContentValuesPrateleira(Prateleira prateleira) {
        ContentValues dados = new ContentValues();
        dados.put(NOME, prateleira.getNome());
        dados.put(LOCAL, prateleira.getLocal());
        dados.put(NUMERO,prateleira.getNumero());
        return dados;
    }
    public List<Prateleira> busca(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM "+TABELA+";";
        Cursor c = db.rawQuery(sql, null);

        List<Prateleira> prateleiras = new ArrayList<Prateleira>();
        while (c.moveToNext()) {
            Prateleira prateleira = new Prateleira();
            prateleira.setNome(c.getString(c.getColumnIndex(NOME)));
            prateleira.setLocal(c.getString(c.getColumnIndex(LOCAL)));
            prateleira.setNumero(c.getString(c.getColumnIndex(NUMERO)));
            prateleiras.add(prateleira);
        }
        c.close();
        return prateleiras;
    }
    public void deleta(Prateleira prateleira) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {prateleira.getNumero()};
        db.delete(TABELA, NUMERO+" = ?", params);
    }
    public void limpar() {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {"remover"};
        db.delete(TABELA, "'remover' = ?", params);
    }
    public void altera(Prateleira prateleira) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValuesPrateleira(prateleira);
        String[] params = {prateleira.getNumero()};
        db.update(TABELA, dados, NUMERO +"= ?", params);
    }

}
