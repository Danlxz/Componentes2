package com.example.componentes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import de.svenjacobs.loremipsum.LoremIpsum;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    CustomAdapter adapter;
    List<Item> dataset;
    LoremIpsum lorem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ocultar la toolbar
        getSupportActionBar().hide();

        // Inicializamos la libreria lorem
        lorem = new LoremIpsum();

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

        // Se usa para mejorar el rendimiento, si sabemos que el contenido no va afectar el tamaño del recyclerview
        recycler.setHasFixedSize(true);

        // podemos pasarle como parametro this o getContext()
        recycler.setLayoutManager(new LinearLayoutManager(this));

        // Se enlaza el adapter al RecyclerView para que gestione los datos del dataset
        adapter = new CustomAdapter(dataset);
        recycler.setAdapter(adapter);
    }
}
