package com.example.bdcadastro;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BuscarFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_buscar, container,false);

        //Aqui vai o código BD
        DataManager dm = new DataManager(getActivity());

        EditText nome = v.findViewById(R.id.editBuscarNome);
        Button btn = v.findViewById(R.id.btBuscar);
        TextView resultado = v.findViewById(R.id.textResultado);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Cursor c = dm.consulta(nome.getText().toString());
                //Verificação para saber se achou resultados
                if (c.getCount()>0){
                    c.moveToNext();
                    String texto = "Resultado = " + c.getString(1)+ " - " + c.getString(2);
                    resultado.setText(texto);
                }
            }
        });

        return v;
    }
}
