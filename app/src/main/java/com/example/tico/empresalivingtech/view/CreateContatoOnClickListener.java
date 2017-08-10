package com.example.tico.empresalivingtech.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tico.empresalivingtech.R;
import com.example.tico.empresalivingtech.controller.ContatoController;
import com.example.tico.empresalivingtech.model.Contato;

/**
 * Created by Alberto  03/06/2017.
 */
public class CreateContatoOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        final Context context = view.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.contato_form, null, false);

        final EditText editTextContatoNome = (EditText) formElementsView.findViewById(R.id.editTextContatoNome);
        final EditText editTextContatoEmail = (EditText) formElementsView.findViewById(R.id.editTextContatoEmail);

        new AlertDialog.Builder(context)
            .setView(formElementsView)
            .setTitle("Criar Contato")
            .setPositiveButton("Incluir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    // Regra de negocio para incluir novos contatos
                    String contatoNome = editTextContatoNome.getText().toString();
                    String contatoEmail = editTextContatoEmail.getText().toString();

                    Contato contato = new Contato();
                    contato.setNome(contatoNome);
                    contato.setEmail(contatoEmail);

                    boolean CriadoComSucesso = new ContatoController(context).create(contato);

                    if (CriadoComSucesso){
                        Toast.makeText(context, "Contato incluido com Sucesso.",Toast.LENGTH_LONG).show();

                        ((CadastroActivity) context).contadorDeRegistro();
                        ((CadastroActivity) context).atualizarListaDeContatos();

                    }else {
                       Toast.makeText(context, "Não foi possivel incluie dados ",Toast.LENGTH_LONG).show();

                    }

                    dialogInterface.cancel();
                }
            }).show();


    }
}
