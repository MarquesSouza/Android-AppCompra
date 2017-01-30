package com.example.marquesdesouza.appcomprafacil;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.marquesdesouza.appcomprafacil.DAO.PrateleiraDAO;
import com.example.marquesdesouza.appcomprafacil.model.Prateleira;

import java.util.ArrayList;
import java.util.List;

public class ListaPrateleiraActivity extends AppCompatActivity {
    private ListView lista_prateleria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prateleira);
        lista_prateleria=(ListView) findViewById(R.id.lista_prateleira);
        lista_prateleria.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> lista, View prateleiras, int i, long l) {
                Prateleira prateleira = (Prateleira) lista_prateleria.getItemAtPosition(i);
                Intent intetGoListaPrateleira= new Intent(ListaPrateleiraActivity.this,ListaPrateleiraActivity.class);
                intetGoListaPrateleira.putExtra("prateleira",prateleira);
                startActivity(intetGoListaPrateleira);
            }
        });
        Button novaPrateleira = (Button) findViewById(R.id.btn_add_prateleria);

        novaPrateleira.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentGoFormularioTurma = new Intent(ListaPrateleiraActivity.this, FormPrateleriaActivity.class);
                        startActivity(intentGoFormularioTurma);
                    }
                }
        );
        carregalista();
        registerForContextMenu(lista_prateleria);
    }

    private void carregalista(){
        PrateleiraDAO dao = new PrateleiraDAO(this);
        List<Prateleira>prateleiras = dao.busca(); dao.close();
        ArrayAdapter<Prateleira> adpter =  new ArrayAdapter<Prateleira>(this,android.R.layout.simple_list_item_1 ,prateleiras);
        List<String> teste=new ArrayList<>();
        String testes=dao.buscateste().toString();
        AlertDialog.Builder temp= new AlertDialog.Builder(this);
        temp.setMessage(testes);
        temp.show();

        lista_prateleria.setAdapter(adpter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregalista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuContexto =  menu.add("deletar");
        menuContexto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Prateleira prateleira = (Prateleira) lista_prateleria.getItemAtPosition(info.position);
                PrateleiraDAO dao = new PrateleiraDAO(ListaPrateleiraActivity.this);
                dao.deleta(prateleira);
                dao.close();
                carregalista();


                return false;
            }
        });
        menuContexto =  menu.add("Alterar");
        menuContexto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                return false;
            }
        });

    }
}

