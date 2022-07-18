package com.example.listadetarefas.activity;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.listadetarefas.adapter.TarefasAdapter;
import com.example.listadetarefas.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefas.helper.RecyclerItemClickListener;
import com.example.listadetarefas.model.Tarefas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TarefasAdapter tarefasAdapter;
    private List<Tarefas> listaTarefas = new ArrayList <>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        recyclerView = findViewById(R.id.recyclerView);
        //Adicionar evento de clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("clique", "onItemClick");

            }

            @Override
            public void onLongItemClick(View view, int position) {
            Log.i("Clique", "onItemLongclick");
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
        super.onCreate(savedInstanceState);






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);

            }
        });
    }
    public void listarTarefas(){
        // Listar tarefas
        Tarefas tarefas1 = new Tarefas();
        tarefas1.setNomeTarefa("ir ao mercado");
        listaTarefas.add(tarefas1);


        Tarefas tarefas2 = new Tarefas();
        tarefas2.setNomeTarefa("ir a feira");
        listaTarefas.add(tarefas2);




        // Exibindo RecyclerView




        //Configurando Adaapter
        TarefasAdapter tarefasAdapter = new TarefasAdapter(listaTarefas);



        // Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tarefasAdapter);



    }
    ProgressBar progressBar = findViewById(R.id.prograssbar);


    @Override
    protected void onStart() {
        listarTarefas();

        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}