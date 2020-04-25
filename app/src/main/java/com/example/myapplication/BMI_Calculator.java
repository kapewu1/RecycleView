package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_Calculator extends AppCompatActivity implements View.OnClickListener {
    Button summitButton;
    EditText kgEd;
    EditText cmEd;
    TextView resultView;
    TextView compView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        summitButton = findViewById(R.id.summitButton);
        kgEd = findViewById(R.id.weightEditText);
        cmEd = findViewById(R.id.heightEditText);
        resultView = findViewById(R.id.bmi_result);
        compView = findViewById(R.id.comparmentsView);

        summitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        bmiCalc();
    }
    private static boolean isBetween(double x,double lower, double upper)
    {
        return lower <= x && x <=upper;
    }
    private int setSwitch(double result)
    {
        int number = 0;
        if (isBetween(result,1.0,15.99))
            number = 1;

        else if (isBetween(result,16.0,16.99))
            number = 2;

        else if (isBetween(result,17.0,18.49))
            number = 3;

        else if (isBetween(result,18.5,24.99))
            number = 4;

        else if (isBetween(result,25.0,29.99))
            number = 5;

        else if (isBetween(result,30.0,34.99))
            number = 6;

        else if (isBetween(result,35.0,39.99))
            number = 7;

        else if (isBetween(result,40.0,300.0))
            number = 8;

        return number;
    }

    private void bmiCalc()
    {
        double weight = Double.parseDouble(kgEd.getText().toString());
        double height = Double.parseDouble(cmEd.getText().toString());

        double sqrtHeight = (height/100)*(height/100);
        double result = weight / sqrtHeight;

        result*=10;
        result = Math.round(result);
        result/=10;

        String resultInString = Double.toString(result);
        resultView.setText("BMI : "+resultInString);


        int number = setSwitch(result);
        switch (number) {
            case 1: {
                compView.setText(R.string.UNDER_16);
                compView.setTextColor(Color.RED);
                break;
            }
            case 2: {
                compView.setText(R.string.TO_17);
                compView.setTextColor(Color.RED);
                break;
            }
            case 3: {
                compView.setText(R.string.TO_18);
                compView.setTextColor(Color.YELLOW);
                break;
            }
            case 4:
            {
                compView.setText(R.string.TO_25);
                compView.setTextColor(Color.GREEN);
                break;
            }
            case 5: {
                compView.setText(R.string.TO_30);
                compView.setTextColor(Color.YELLOW);
                break;
            }
            case 6: {
                compView.setText(R.string.TO_35);
                compView.setTextColor(Color.RED);
                break;
            }
            case 7:{
                compView.setText(R.string.TO_40);
                compView.setTextColor(Color.RED);
                break;
            }
            case 8:{
                compView.setText(R.string.ABOVE_40);
                compView.setTextColor(Color.RED);
                break;
            }
        }

    }



}
