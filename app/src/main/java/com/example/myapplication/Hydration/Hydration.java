package com.example.myapplication.Hydration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Calendar;


public class Hydration extends AppCompatActivity {

    public static final int DEFAULT = 0;
    private static final String DATE_SAVED = "date";
    private static final String WATER = "water";
    private ImageView glassBtn;
    private TextView quantity;
    private TextView valueOfWater;
    private SeekBar setValueOFWater;
    private int state = 0;
    private int waterValue = 0;
    private int maxWater = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydration);

        //Initialize Variavles
        quantity = findViewById(R.id.quantity);
        glassBtn = findViewById(R.id.glass_water);
        valueOfWater = findViewById(R.id.value);
        setValueOFWater = findViewById(R.id.seekbar);

        //Initialize Date
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //Check if SharedPrefs exist
        SharedPreferences checkDate = getSharedPreferences(DATE_SAVED,MODE_PRIVATE);
        SharedPreferences.Editor ed;
        if(!checkDate.contains("initialized")){
            ed = checkDate.edit();
            //if Date not exist put value to our Date
            ed.putInt(DATE_SAVED,day);
        }
        int saved_day = checkDate.getInt(DATE_SAVED,MODE_PRIVATE);

        if(saved_day != day){
            saveDate(day);
            pourWater();
            int zero = 0;
            valueOfWater.setText(zero+" ml");

        }


        //Initialize SharedPrefences
        SharedPreferences sharedPreferences = getSharedPreferences("water", MODE_PRIVATE);

        //Load SharedPreferences
        Integer value = sharedPreferences.getInt("water",DEFAULT);
        state = value;
        quantity.setText(String.valueOf(state+" / 3000"));

        // Set OnClick Variables
        setValueOFWater.setMax(1000);
        setValueOFWater.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueOfWater.setText(progress+" ml");
                waterValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        glassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
                v.startAnimation(AnimationUtils.loadAnimation(Hydration.this,R.anim.glass));
            }
        });

    }
    private void increase(){
        if(state>=maxWater) return;
        else if (state+waterValue>=maxWater){
            quantity.setText(String.valueOf(maxWater) + " / 3000 ml");
        }
        quantity.setText(String.valueOf(state + waterValue) + " / 3000 ml");
        state+=waterValue;
        //Save SharedPreferences
        saveData(WATER, state);
    }
    private void saveData(String name, int direction_from) {
        SharedPreferences sharedPreferences = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(name, direction_from);
        editor.commit();

    }
    private void saveDate(int date)
    {
        SharedPreferences sharedPreferences = getSharedPreferences(DATE_SAVED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(DATE_SAVED,date);
        editor.commit();
    }
    private void pourWater(){
        SharedPreferences sharedPreferences = getSharedPreferences(WATER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(WATER, 0);
        editor.commit();
    }


}
