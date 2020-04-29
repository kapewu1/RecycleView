package com.example.myapplication.FitCalculators;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.MainPage.MainModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Calculators extends AppCompatActivity {
    ImageView backbuttom;

    RecyclerView calcRecyclerView;
    ArrayList<MainModel> objectHolder;
    CalculatorRecycleAdapter calcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        //Initializate RecycleView

        calcRecyclerView = findViewById(R.id.recycle_view_calc);

        //Create Integer table for item logos

        Integer [] ITEM_IMG = {
                R.drawable.scale,
                R.drawable.kettlebell,
                R.drawable.barbell,
                R.drawable.scale,
                R.drawable.barbell
        };

        // Create String table of Calculator Names

        String [] ITEM_NAME = {
                "BMI KALKULATOR",
                "BMR KALKULATOR",
                "BODY FAT CALCULATOR",
                "REDUCTION CALCULATOR",
                "ONE REP CALCULATOR"
        };

        // Initialize ArrayList

        objectHolder = new ArrayList<>();

        for( int i =0; i< ITEM_IMG.length; i++) {
            MainModel object = new MainModel(ITEM_IMG[i],ITEM_NAME[i]);
            objectHolder.add(object);

        }

        // Set Design of RecycleView

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Calculators.this,LinearLayoutManager.VERTICAL,false
        );
        calcRecyclerView.setLayoutManager(layoutManager);
        calcRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Initialize Adapter
        calcAdapter =  new CalculatorRecycleAdapter(Calculators.this,objectHolder);

        // Set Adapter
        calcRecyclerView.setAdapter(calcAdapter);
        //Set onClickListener

        calcAdapter.setOnItemClickListener(new CalculatorRecycleAdapter.OnItemClickListener() {
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
                Intent intent = new Intent(Calculators.this, BMI_Calculator.class);
                startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(Calculators.this, BMR_Calculator.class);
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(Calculators.this, BodyFat_Calculator.class);
                startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(Calculators.this, Reduction_Calculator.class);
                startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(Calculators.this, OneRep_Calculator.class);
                startActivity(intent);
                break;
            }
        };

    }
}
