package com.example.bdcadastro;

import android.app.ActionBar;
import android.app.Notification;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bdcadastro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Faz referencia ao layout que estamos criando
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //Cria objeto que controla os drawers
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar
                ,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //Chama os Listeners, ou seja, gerenciadores de eventos
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Editando o que acontece quando aperta o botão voltar
    //Se o Drawer estiver aberto, fecha o drawer
    //Caso contrario executa o comportamento normal

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    //Manipular os dados da barra de ação
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Manipular os eventos do menu de navegação(View Navigation)
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Cria uma transaction, ou seja, um conjunto de operações com fragmentos diferentes
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        int id = item.getItemId();
        if (id == R.id.nav_insert) {
            //Criar novo fragmento do tipo apropriado!
            InsertFragment fragment = new InsertFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        } else if (id == R.id.nav_delete) {
            //Criar novo fragmento do tipo apropriado!
            DeleteFragment fragment = new DeleteFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        } else if (id == R.id.nav_buscar) {
            //Criar novo fragmento do tipo apropriado!
            BuscarFragment fragment = new BuscarFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        } else if (id == R.id.nav_listar) {
            //Criar novo fragmento do tipo apropriado!
            ListarFragment fragment = new ListarFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        }
        //Armazenar a seleção do usuário
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}