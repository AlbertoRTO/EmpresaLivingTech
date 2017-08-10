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
 * Created by Alberto on 03/06/2017.
 */
public class RetriveOnlongCLickListener implements  View.OnLongClickListener {

    Context context;
    String id;


    @Override
    public boolean onLongClick(View view) {

        context = view.getContext();
        id = view.getTag().toString();

        final CharSequence[] itens = {"Atualizar","Deletar"};

        new AlertDialog.Builder(context).setTitle("Detalhe do Cliente")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {

                        if (item == 0){
                          //editar
                            editarContatoPeloID(Integer.parseInt(id));
                        } else if (item == 1){
                          //deletar

                            boolean isDeletouCOmSucesso =
                                    new ContatoController(context).delete(Integer.parseInt(id));

                            if (isDeletouCOmSucesso){
                                Toast.makeText(context, "Cliente' deletado.",Toast.LENGTH_SHORT).show();

                                ((CadastroActivity)context).contadorDeRegistro();
                                ((CadastroActivity)context).atualizarListaDeContatos();

                            } else {
                                Toast.makeText(context, "Erro ao deletar o contato.", Toast.LENGTH_SHORT).show();
                            }


                        }

                    }
                }).show();


        Toast.makeText(view.getContext()," Clincado em um Cliente da lista ",Toast.LENGTH_SHORT).show();

                return false;
    }

    public void editarContatoPeloID(final int contatoID){

        Toast.makeText(context, "Editando "+contatoID,Toast.LENGTH_SHORT).show();
        //Objetivo - Montar o Formulario ja com os Dados Populados

        //ContatoController

          final ContatoController contatoController = new ContatoController(context);

        //Contato via DB pela PK (ContatoID)
        final Contato contato = contatoController.BuscarPeloID(contatoID);

        //Injetar o layout contato_form

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View formContato = inflater.inflate(R.layout.contato_form,null,false);

        //Pupular nome e email  com dados da lista

        final EditText editTextNome = (EditText)formContato.findViewById(R.id.editTextContatoNome);
        final EditText editTextEmail = (EditText)formContato.findViewById(R.id.editTextContatoEmail);


        editTextNome.setText(contato.getNome());
        editTextEmail.setText(contato.getEmail());

        //Show do formulario com dados populados

        new AlertDialog.Builder(context)
                .setView(formContato)
                .setTitle("Editar")
                .setPositiveButton("Atualizar Dados", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                   //Regra de negocio Salvar/Update

                        Contato novoContato = new Contato();
                        novoContato.setId(contatoID);
                        novoContato.setNome(editTextNome.getText().toString());
                        novoContato.setEmail(editTextEmail.getText().toString());

                        boolean isUpdate = contatoController.upadate(novoContato);

                        if (isUpdate){
                            Toast.makeText(context, "Dados Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
                            ((CadastroActivity) context).atualizarListaDeContatos();


                        }else{
                            Toast.makeText(context, "Falha ao Salvar Contato", Toast.LENGTH_SHORT).show();
                        }

                     dialogInterface.cancel();
                    }
                }).show();



        //Deixar o usuario alterar os dados
        //Criar um OBJ Contato com os dados digitados
        //Salvar via Update da Controller
        //Atualizar view  na CadastroActivity



    }
}
