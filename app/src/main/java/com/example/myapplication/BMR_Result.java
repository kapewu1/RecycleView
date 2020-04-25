package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class BMR_Result extends AppCompatActivity {
    private TextView bmr_result;
    private TextView cpm_result;
    private TextView cal_to_lose;
    private TextView cal_to_grow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmr_result);


        bmr_result = findViewById(R.id.bmr_result);
        cpm_result = findViewById(R.id.cpm_result);
        cal_to_lose = findViewById(R.id.cal_to_lose);
        cal_to_grow = findViewById(R.id.cal_to_grow);


        Intent intent = getIntent();
        String bmr = Integer.toString(intent.getIntExtra("BMR",0));
        String cpm = Integer.toString(intent.getIntExtra("CPM",0));
        String cpm_lose = Integer.toString(intent.getIntExtra("CPM_lose",0));
        String cpm_grow = Integer.toString(intent.getIntExtra("CPM_grow",0));

        bmr_result.setText("BMR : "+bmr+" kcal");
        cpm_result.setText("CPM : "+cpm+" kcal");
        cal_to_grow.setText("Aby przytyć : "+cpm_grow+" kcal");
        cal_to_lose.setText("Aby schudnąć : "+cpm_lose+" kcal");
    }
}
