package com.example.bdcadastro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;

public class DataManager {
    //cria a variavel do banco
    private SQLiteDatabase db;
    //Define as constantes para conexão com o banco
    public static final String DB_NAME = "bd_nome_idade";
    public static final int DB_VERSION = 1;
    public static final String TABELA_N_I = "nome_idade";

    //Define as contantes com os nomes da coluna
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_IDADE = "idade";


    //Cria o construtor da classe
    public DataManager(Context context){
        //Cria instancia do nosso helper
        NossoSQLiteOpenHelper helper = new NossoSQLiteOpenHelper(context);
        //Obtém uma base de dados editavel
        db = helper.getWritableDatabase();
    }

    //Inserir um registro
    public void inserir(String nome, String idade){
        String query = "INSERT INTO " + TABELA_N_I
                +"(" + COLUNA_NOME + "," + COLUNA_IDADE + ")"
                + "VALUES (" + "'" + nome + "','" + idade + "');";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }
    //Excluir um registro
    public void delete(String nome){
        String query = "DELETE FROM " + TABELA_N_I + " WHERE " + COLUNA_NOME + " = '" + nome +"';";
        Log.i("delete() = ", query);
        db.execSQL(query);
    }
    //Listar Registros
    public Cursor listar(){
        String query = "SELECT * FROM " + TABELA_N_I+";";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    //Buscar registros
    public Cursor consulta(String nome){
        String query = "SELECT "+ COLUNA_ID + "," + COLUNA_NOME + "," + COLUNA_IDADE
                + "FROM " + TABELA_N_I + " WHERE "
                + COLUNA_NOME + "= '" + nome + "';";
        Log.i("consulta() = ", query);
        Cursor c = db.rawQuery(query,null);
        return c;
    }



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

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
