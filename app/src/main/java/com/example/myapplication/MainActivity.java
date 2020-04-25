package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
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

        Integer [] ACTIVITY_LOGO = {
                R.drawable.barbell,
                R.drawable.calendar,
                R.drawable.diet,
                R.drawable.kettlebell,
                R.drawable.calculator,
                R.drawable.market
        };

        //Create String Array

         String [] ACTIVITY_NAME = getResources().getStringArray(R.array.ACTIVITIES);
         String [] ACTIVITY_DESCRIPTION = getResources().getStringArray(R.array.DESCRIPTION);

        //Initialize ArrayList

        mainModels = new ArrayList<>();
        for (int i=0; i< ACTIVITY_LOGO.length;i++) {
            MainModel model = new MainModel(ACTIVITY_LOGO[i],ACTIVITY_NAME[i],ACTIVITY_DESCRIPTION[i]);
            mainModels.add(model);
        }

        //Design Horizonal Layout

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.smoothScrollBy(10,20);
        // Set size of space between each object in RecycleView

     //  RecyclerViewMargin decoration = new RecyclerViewMargin(400,ACTIVITY_LOGO.length);
        //recyclerView.addItemDecoration(decoration);


        // Initialize MainAdapter
        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        //Set MainAdapter to RecycleView
        recyclerView.setAdapter(mainAdapter);
        // Initialize OnClickItemListener
        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),Integer.toString(position),Toast.LENGTH_LONG).show();
                activityIntentHelper(position);
            }
        });

    }
    public void activityIntentHelper(int position)
    {
        int number = position;

        switch (number){

            case 0:{
            Intent intent = new Intent(this, Training.class);
                startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(this, Calendar.class);
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(this, Nutrition.class);
                startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(this, TraningGenerator.class);
                startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(this, Calculators.class);
                startActivity(intent);
                break;
            } case 5:{
                Intent intent = new Intent(this, ShoppingList.class);
                startActivity(intent);
                break;
            }
        };

    }
}
