package com.example.myapplication.MainPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.FitCalculators.Calculators;
import com.example.myapplication.Calendar;
import com.example.myapplication.Hydration.Hydration;
import com.example.myapplication.Nutrition;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingList.ShoppingList;
import com.example.myapplication.Training;
import com.example.myapplication.TraningGenerator;

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
                R.drawable.market,
                R.drawable.water
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

        // Initialize MainAdapter
        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        //Set MainAdapter to RecycleView
        recyclerView.setAdapter(mainAdapter);
        // Initialize OnClickItemListener
        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
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
            }case 6:{
                Intent intent = new Intent(this, Hydration.class);
                startActivity(intent);
                break;
            }
        };

    }
}
