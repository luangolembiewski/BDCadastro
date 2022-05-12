package com.example.bdcadastro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class DataManager {
    //Define as constantes para conexão com o banco
    public static final String DB_NAME = "bd_nome_idade";
    public static final int DB_VERSION = 1;
    public static final String TABELA_N_I = "nome_idade";

    //Define as contantes com os nomes da coluna
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_IDADE = "idade";

    private class NossoSQLiteOpenHelper extends SQLiteOpenHelper {
        //Cria o método construtor na classe
        public NossoSQLiteOpenHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase){
            String queryNovaTabela = "CREATE TABLE "
                    +TABELA_N_I + "("
                    +COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    +COLUNA_NOME + "TEXT NOT NULL,"
                    +COLUNA_IDADE + "TEXT NOT NULL);";
            sqLiteDatabase.execSQL(queryNovaTabela);
        }
    }
}
