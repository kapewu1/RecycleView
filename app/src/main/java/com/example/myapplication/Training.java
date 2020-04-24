package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Training extends AppCompatActivity {

    ImageView backbuttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);

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
