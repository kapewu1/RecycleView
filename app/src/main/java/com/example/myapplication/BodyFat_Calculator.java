package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BodyFat_Calculator extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit_button;
    private EditText ageText;
    private EditText weightText;
    private EditText heightText;
    private EditText neckText;
    private EditText waistText;
    private EditText hipText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_fat_calculator);

        ageText = findViewById(R.id.ageEditText);
        weightText = findViewById(R.id.weightEditText);
        heightText = findViewById(R.id.heightEditText);
        neckText = findViewById(R.id.neckEditText);
        waistText = findViewById(R.id.waistEditText);
        hipText = findViewById(R.id.hipEditText);
        submit_button = findViewById(R.id.submit_button);
        radioGroup = findViewById(R.id.radioGroup);


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double bf_cal_navy =  bfCalculatorUS_Navy();
                double bf_cal_bmi = bfCalculator_BMI();
                double weight = Double.parseDouble(weightText.getText().toString());
                double fat_mass = roundDoubles((bf_cal_navy/100) * weight);
                double lean_mass = roundDoubles(weight - fat_mass);


                Intent intent =  new Intent(BodyFat_Calculator.this,BodyFat_Result.class);
                intent.putExtra("bf_navy",bf_cal_navy);
                intent.putExtra("bf_bmi",bf_cal_bmi);
                intent.putExtra("fat_mass",fat_mass);
                intent.putExtra("lean_mass",lean_mass);

                startActivityForResult(intent,1);
            }
        });


    }
    private double roundDoubles(double number) {
        number*=10;
        number = Math.round(number);
        number= number/10;
        return number;
    }
    private double bfCalculatorUS_Navy()
    {   double body_fat = 0;

        double age = Double.parseDouble(ageText.getText().toString());
        double weight = Double.parseDouble(weightText.getText().toString());
        double height = Double.parseDouble(heightText.getText().toString());
        double neck = Double.parseDouble(neckText.getText().toString());
        double waist = Double.parseDouble(waistText.getText().toString());
        double hip = Double.parseDouble(hipText.getText().toString());

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String gender = (String) radioButton.getText();

        if(gender.equals("Mężczyzna")){
            body_fat =  (495
                    / (1.0324 - (0.19077 * Math.log10(waist-neck)) + 0.15456 * Math.log10(height)))
                    - 450;

            return roundDoubles(body_fat);
        }

        else{
            body_fat = (495
                    / (1.29579- (0.35004*Math.log10(waist+(hip-neck)) + 0.22100*Math.log10(height)))
                    -450);
            return roundDoubles(body_fat);
        }
    }
    private double bfCalculator_BMI()
    {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String gender = (String) radioButton.getText();

        double age = Double.parseDouble(ageText.getText().toString());
        double weight = Double.parseDouble(weightText.getText().toString());
        double height = Double.parseDouble(heightText.getText().toString());
        double body_fat = 0;
        double sqrtHeight = (height/100)*(height/100);

        double bmi = weight/sqrtHeight;



        if(gender.equals("Mężczyzna")) {
            body_fat =  1.2 * bmi + 0.23 * age - 16.2;
        }
        else if(gender.equals("Kobieta")) {
            body_fat = 1.2 * bmi + 0.23 * age - 5.4;
        }
        else if(age<= 16 && gender.equals("Mężczyzna"))
        {
            body_fat = 1.51 * bmi - 0.7 * age - 2.2;
        }
        else if(age<= 16 && gender.equals("Kobieta")){
            body_fat = 1.51 * bmi - 0.7 * age + 1.4;
        }

        return roundDoubles(body_fat);
    }

}
