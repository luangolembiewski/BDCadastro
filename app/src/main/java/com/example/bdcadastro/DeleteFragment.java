package com.example.bdcadastro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class DeleteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_deletar, container,false);

        //Aqui vai o código BD
        DataManager dm = new DataManager(getActivity());
        Button btn = v.findViewById(R.id.btDeletar);
        EditText nome = v.findViewById(R.id.editDeleteNome);
        EditText idade = v.findViewById(R.id.editDeleteIdade);

        //Pega o evento de clique no botão
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dm.delete(nome.getText().toString());
            }
        });


        return v;
    }
}
