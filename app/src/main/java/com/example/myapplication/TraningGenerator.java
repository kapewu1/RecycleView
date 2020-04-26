package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.MainPage.MainActivity;

public class TraningGenerator extends AppCompatActivity {
    ImageView backbuttom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning_generator);
        backbuttom = findViewById(R.id.backbutton);
        backbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TraningGenerator.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
