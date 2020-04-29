package com.example.myapplication.FitCalculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class OneRep_Calculator extends AppCompatActivity {

    Button btn1;
    TextView question;
    EditText one_rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_rep_calculator);
        btn1 = findViewById(R.id.button1);
        question = findViewById(R.id.questionText);
        one_rep = findViewById(R.id.one_rep_lift);

    }
}
