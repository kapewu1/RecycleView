package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Initialization Variable
    RecyclerView recyclerView;


    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variable
        recyclerView = findViewById(R.id.recycle_view);

        //Create Integer Array

        Integer [] activLogo = {
                R.drawable.barbell,
                R.drawable.calendar,
                R.drawable.diet,
                R.drawable.kettlebell,
                R.drawable.scale};

        //Create String Array

        String [] activName = {
                "Training",
                "Calendar",
                "Nutrition",
                "Training Generator",
                "Fitness Calculators"
        };
        String [] activDescription = {
                "Twój własny plan treningowy. Zaplanuj swoje treningi w oparciu o Generator Treningu i zapisz je tutaj by zyskać możliwość śledzenia swoich postępów oraz monitorowania czy twój trening przynosi zakładane rezultaty",
                "Terminarz pozwoli ci na dokładne śledzenie twojej aktywności fizycznej oraz założeń żywieniowych na przestrzeni twojej drogi po idealną sylwetkę. Zapisuj swoje postępy, aby nigdy o nich nie zapomnieć",
                "Dieta to najważniejsza składowa procesu budowania idealne sylwetki. Zapisuj swój dzienny jadłospis w oparciu o wszystkie makro i mikro składniki, utrzymuj bilans kaloryczny zgodnie z wytycznymi, aby osiągnąć zamierzony efekt.",
                "Stwórz swój własny plan treningowy w oparciu o naszą bazę danych ćwiczeń i dostosuj go tak, aby spełniał twoje wszelkie wymagania. Określ swoje cele i działaj!",
                "Aby móc prawidłowo oszacować ilość spożywanych kalorii, sprawdzić obecy poziom tkanki tłuszczowej, czy też określić idealną wagę określaną na podstawie naszych parametrów z pomocą przychodzą kalkulatory ułatwiające rozpoczęcie drogi ze zdorwym odżywianiem"

        };

        //Initialize ArrayList

        mainModels = new ArrayList<>();
        for (int i=0; i< activLogo.length;i++) {
            MainModel model = new MainModel(activLogo[i],activName[i]);
            mainModels.add(model);
        }


        //Design Horizonal Layout

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Set size of space between each object in RecycleView

     //   RecyclerViewMargin decoration = new RecyclerViewMargin(400,activLogo.length);
       // recyclerView.addItemDecoration(decoration);


        // Initialize MainAdapter
        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        //Set MainAdapter to RecycleView
        recyclerView.setAdapter(mainAdapter);


    }
}
