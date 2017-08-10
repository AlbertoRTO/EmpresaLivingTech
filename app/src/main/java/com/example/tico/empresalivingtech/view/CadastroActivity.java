package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tico.empresalivingtech.R;
import com.example.tico.empresalivingtech.controller.ContatoController;
import com.example.tico.empresalivingtech.model.Contato;

import java.util.List;

public class CadastroActivity extends Activity {


    Button btnAdicionar,btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new CreateContatoOnClickListener());

        contadorDeRegistro();
        atualizarListaDeContatos();

    }

    public void contadorDeRegistro() {
        String msg = "";

        int contador = new ContatoController(this).totalDeContatos();

        TextView txtContatorContatos = (TextView) findViewById(R.id.txtContadorContatos);

        if (contador == 0) {

            msg = " Nenhum Cliente Cadastrado.";

        } else if (contador == 1) {

            msg = contador + " Cliente Cadastrado.";

        } else {

            msg = contador + " CLientes Cadastrados.";
        }

        txtContatorContatos.setText(msg);
    }

    public void atualizarListaDeContatos(){

        LinearLayout linearLayoutRecords = (LinearLayout)
                findViewById(R.id.objetosContatos);
        linearLayoutRecords.removeAllViews();

        List<Contato> students = new ContatoController(this).listContatos();

        if (students.size() > 0){

             for (Contato obj : students){

                 int id = obj.getId();
                 String nome = obj.getNome();
                 String email = obj.getEmail();

                 String textViewContents = nome + " - " + email;

                 TextView textViewContatoItem= new TextView(this);
                 textViewContatoItem.setPadding(0, 10, 0, 10);
                 textViewContatoItem.setText(textViewContents);
                 textViewContatoItem.setTag(Integer.toString(id));


                 linearLayoutRecords.addView(textViewContatoItem);
                 textViewContatoItem.setOnLongClickListener(new RetriveOnlongCLickListener());

             }

        }

        else {
            TextView locationItem = new TextView(this);
            locationItem.setPadding(8,8,8,8);
            locationItem.setText("Nenhum Cliente Cadastrado.");

            linearLayoutRecords.addView(locationItem);

        }

    }

}
