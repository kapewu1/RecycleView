package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.MainPage.MainActivity;

import java.util.ArrayList;

public class Training extends AppCompatActivity {

    private ImageView backbuttom;
    private RecyclerView recyclerView;
    private TraningAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);

        //Initialize ArrayList of Objects TraningItem

        final ArrayList<TraningItem> itemArrayList = new ArrayList<>();

        itemArrayList.add(new TraningItem(R.drawable.barbell,"Barki","Siłowy","02/12/2019"));
        itemArrayList.add(new TraningItem(R.drawable.barbell,"Rowerek","Cardio","02/12/2019"));
        itemArrayList.add(new TraningItem(R.drawable.barbell,"Zumba z Madzią","Zumba","02/12/2019"));

        recyclerView = findViewById(R.id.treningRecycleView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TraningAdapter(itemArrayList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);




        mAdapter.setOnItemClickListener(new TraningAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position,View v) {
                if(state == 0){

                    itemArrayList.get(position).expand(v,2000,500);
                    state++;

                }
                else if(state == 1){
                    itemArrayList.get(position).collapse(v,2000,250);
                    state = 0;
                }
            }
        });

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
