package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        // posprzątać ten błagan
        //backbuttom = findViewById(R.id.backbutton);
      //  backbuttom.setOnClickListener(new View.OnClickListener() {
         //   @Override
        //        Intent intent = new Intent(Calculators.this, MainActivity.class);
       //         startActivity(intent);
       //     }
     //  });

        //Initializate RecycleView

        calcRecyclerView = findViewById(R.id.recycle_view_calc);

        //Create Integer table for item logos

        Integer [] ITEM_IMG = {
                R.drawable.scale,
                R.drawable.kettlebell,
                R.drawable.barbell
        };

        // Create String table of Calculator Names

        String [] ITEM_NAME = {
                "BMI KALKULATOR",
                "BMR KALKULATOR",
                "BODY FAT CALCULATOR"
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




    }
}
