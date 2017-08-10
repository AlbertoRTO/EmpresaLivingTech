package com.example.tico.empresalivingtech.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tico on 03/06/2017.
 */
public class DataBaseAdapter extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "CrudCompleto.DB";

    public DataBaseAdapter(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql ="CREATE TABLE contato " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome TEXT," +
                " email TEXT);";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //observação:
        /**
         * criar os procedimentos de backup do banco de dados e seus dados
         * antes de efetuar um upgrade de versão
         */

        String sql = "DROP TABLE IF EXISTS contato";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
}
