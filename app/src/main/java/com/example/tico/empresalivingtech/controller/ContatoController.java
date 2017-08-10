package com.example.tico.empresalivingtech.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tico.empresalivingtech.database.DataBaseAdapter;
import com.example.tico.empresalivingtech.model.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tico on 03/06/2017.
 */
public class ContatoController extends DataBaseAdapter {

    public ContatoController(Context context){
        //integração com banco de dados
        super(context);
    }

    public boolean create(Contato contato){

        ContentValues values = new ContentValues();

        values.put("nome", contato.getNome());
        values.put("email", contato.getEmail());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        boolean isCreat = sqLiteDatabase.insert("contato", null, values) > 0;
        sqLiteDatabase.close();

        return isCreat;
    }

    public int totalDeContatos(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "SELECT * FROM contato";

        int contador = sqLiteDatabase.rawQuery(sql, null).getCount();

        return contador;

    }

    public List<Contato> listContatos(){

        List<Contato> contatos = new ArrayList<>();

        String sql ="SELECT * FROM contato ORDER by id DESC";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if (cursor.moveToFirst()){

            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String email = cursor.getString(cursor.getColumnIndex("email"));

                Contato contato = new Contato();

                contato.setId(id);
                contato.setNome(nome);
                contato.setEmail(email);
                contatos.add(contato);

            }while (cursor.moveToNext());

        }

        cursor.close();
        sqLiteDatabase.close();

        return contatos;
   }

    public Contato BuscarPeloID(int ContatoID){

       Contato contato = null;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "SELECT * FROM contato WHERE id = "+ContatoID;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if (cursor.moveToFirst()){

            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String email = cursor.getString(cursor.getColumnIndex("email"));

            contato = new Contato();

            contato.setId(ContatoID);
            contato.setNome(nome);
            contato.setEmail(email);

        }

        return contato;
    }

    public boolean upadate(Contato contato){

       ContentValues values = new ContentValues();

        values.put("nome", contato .getNome());
        values.put("email", contato.getEmail());

        String where = "id = ?";

        String[] whereArgs = {Integer.toString(contato.getId())};

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        boolean isUpdade = sqLiteDatabase.update("contato ", values, where, whereArgs) > 0;

        sqLiteDatabase.close();

        return  isUpdade;

    }

    public boolean delete(int contatoID){

        boolean isDeletado = false;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        isDeletado = sqLiteDatabase.delete("contato", "id ='" + contatoID + "'",null )>0;
        sqLiteDatabase.close();

        return isDeletado;
    }

}
