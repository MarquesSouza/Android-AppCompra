package com.example.marquesdesouza.appcomprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.marquesdesouza.appcomprafacil.DAO.PrateleiraDAO;
import com.example.marquesdesouza.appcomprafacil.model.Prateleira;
import com.example.marquesdesouza.appcomprafacil.model.Produto;

public class FormPrateleriaActivity extends AppCompatActivity {
    private FormHelpPrateleira helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_prateleria);

        helper=new FormHelpPrateleira(this);
        Intent pegaIntent= getIntent();
        Prateleira prateleira=(Prateleira) pegaIntent.getSerializableExtra("prateleria");
        if(prateleira!=null){
            helper.preencherFormulario(prateleira);
        }
    }
    //falta criar o menu superior
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu_form_prateleira, menu);
       return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok_prateleria:
                Prateleira prateleira = helper.pegaPrateleria();
                PrateleiraDAO dao = new PrateleiraDAO(this);

                if(prateleira.getNumero() != null){
                    dao.altera(prateleira);
                    Toast.makeText(FormPrateleriaActivity.this, "Prateleira "+prateleira.getNumero()+" alterada!", Toast.LENGTH_SHORT).show();
                }
                else {
                    dao.insere(prateleira);
                    Toast.makeText(FormPrateleriaActivity.this, "Prateleira "+prateleira.getNumero()+" adicionada!", Toast.LENGTH_SHORT).show();
                }
                dao.close();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

}
