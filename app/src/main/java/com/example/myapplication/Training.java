package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.MainPage.MainActivity;

import java.util.ArrayList;

public class Training extends AppCompatActivity {

    ImageView backbuttom;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);

        //Initialize ArrayList of Objects TraningItem

        ArrayList<TraningItem> itemArrayList = new ArrayList<>();

        itemArrayList.add(new TraningItem(R.drawable.barbell,"Barki","Siłowy","02/12/2019"));
        itemArrayList.add(new TraningItem(R.drawable.barbell,"Rowerek","Cardio","02/12/2019"));
        itemArrayList.add(new TraningItem(R.drawable.barbell,"Zumba z Madzią","Zumba","02/12/2019"));

        recyclerView = findViewById(R.id.treningRecycleView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TraningAdapter(itemArrayList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter );
        backbuttom = findViewById(R.id.backbutton);
        backbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Training.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
