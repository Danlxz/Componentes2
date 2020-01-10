package com.example.componentes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import de.svenjacobs.loremipsum.LoremIpsum;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    CustomAdapter adapter;
    List<Item> dataset;
    LoremIpsum lorem;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Quitarle el titulo en la pantalla de inicio de la app
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Actividad en pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Ocultar la toolbar
        getSupportActionBar().hide();

        // Inicializamos la libreria lorem
        lorem = new LoremIpsum();

        fabSwitcher = findViewById(R.id.fab);
        rootLayout = findViewById(R.id.root_layout);
        // Inicializamos la implementacion del RecyclerView
        recycler = findViewById(R.id.recyclerMain);

        // Se puede llenar por una bd o con firebase
        dataset = new ArrayList<>();
        dataset.add(new Item("Bulbasaur","01-01-2020",lorem.getWords(40),R.drawable.bulba));
        dataset.add(new Item("Ivasaur","01-01-2020",lorem.getWords(40),R.drawable.ivasaur));
        dataset.add(new Item("Venasaur","01-01-2020",lorem.getWords(40),R.drawable.venasaur));
        dataset.add(new Item("Charizard","01-01-2020",lorem.getWords(40),R.drawable.charizard));
        dataset.add(new Item("Charizard Mega","01-01-2020",lorem.getWords(40),R.drawable.lizardmega));
        dataset.add(new Item("Charizard Pro","01-01-2020",lorem.getWords(40),R.drawable.lizard));
        dataset.add(new Item("Gengar","01-01-2020",lorem.getWords(40),R.drawable.gengar));
        dataset.add(new Item("Gengar Mega","01-01-2020",lorem.getWords(40),R.drawable.megagengar));
        dataset.add(new Item("Pikachu Gorra","01-01-2020",lorem.getWords(40),R.drawable.pikagorra));
        dataset.add(new Item("Pikachu + Lugia","01-01-2020",lorem.getWords(40),R.drawable.pikalugia));
        dataset.add(new Item("Salamence","01-01-2020",lorem.getWords(40),R.drawable.salamence));

        // Cargamos el estado del tema preferido que se guardo en el metodo saveThemeState()
        isDark = getThemeState();
        if (isDark){
            rootLayout.setBackgroundColor(getResources().getColor(R.color.colorThemeBlack));
        }else{
            rootLayout.setBackgroundColor(getResources().getColor(R.color.colorThemeWhite));
        }

        // Se usa para mejorar el rendimiento, si sabemos que el contenido no va afectar el tamaño del recyclerview
        recycler.setHasFixedSize(true);

        // podemos pasarle como parametro this o getApplicationContext()
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Se enlaza el adapter al RecyclerView para que gestione los datos del dataset
        adapter = new CustomAdapter(this, dataset, isDark);
        recycler.setAdapter(adapter);

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark){
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.colorThemeBlack));
                }else{
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.colorThemeWhite));
                }
                adapter = new CustomAdapter(getApplicationContext(), dataset, isDark);
                recycler.setAdapter(adapter);
                saveThemeState(isDark);
            }
        });
    }

    private void saveThemeState(boolean isDark) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.apply();
        editor.commit();
    }

    private boolean getThemeState(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false);
        return isDark;
    }


}
