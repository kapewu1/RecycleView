package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Hydration extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String QUANTITY = "quant";


    private ImageView glassBtn;
    private TextView quantity;
    private int saveData;

    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydration);

        quantity = findViewById(R.id.quantity);
        glassBtn = findViewById(R.id.glass_water);


        quantity.setText(String.valueOf(state) + " / 3000 ml");

        glassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

    }
    private void increase(){
        if(state>=3000) return;
        else if (state+300>=3000){
            quantity.setText(String.valueOf(3000) + " / 3000 ml");
        }
        quantity.setText(String.valueOf(state + 300) + " / 3000 ml");
        state+=300;
    }

    /// dokonczyc jest 3:17 nie myślisz Paweł
    private void  saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(QUANTITY, state);
        saveData = sharedPreferences.getInt(QUANTITY,state);
        quantity.setText(String.valueOf(saveData));
    }

}
