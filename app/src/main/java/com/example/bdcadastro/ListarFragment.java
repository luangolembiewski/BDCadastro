package com.example.bdcadastro;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ListarFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_listar, container,false);

        //Aqui vai o código BD
        //Cria um objeto DataManager (permite acesso á tabela e as queries)
        DataManager dm = new DataManager(getActivity());
        //Busca a textView e atribui para a variavel textResultados
        TextView textResultados = v.findViewById(R.id.textLista);
        //Busca os registros na tabela
        Cursor c = dm.listar();
        //String para manipular os resultados
        String resultados = "";
        //Itera por todos os registros encontrados
        while (c.moveToNext()){
            //Adiciona resultados a string
            resultados +=(c.getString(1)+" - " + c.getString(2) + "\n");
        }
        //Exibe os resultados na textView
        textResultados.setText(resultados);
        return v;
    }
}
