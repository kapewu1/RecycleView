package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BodyFat_Result extends AppCompatActivity {
    private TextView bf_navy;
    private TextView bf_bmi;
    private TextView fat_mass;
    private TextView lean_mass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_fat_result);

        bf_bmi = findViewById(R.id.bf_bmi);
        bf_navy = findViewById(R.id.bf_navy);
        fat_mass = findViewById(R.id.fat_mass);
        lean_mass = findViewById(R.id.lean_mass);

        Intent intent = getIntent();



        String bf_navy_result = Double.toString(intent.getDoubleExtra("bf_navy",0));
        String bf_bmi_result =  Double.toString(intent.getDoubleExtra("bf_bmi",0));
        String fat_mass_result =  Double.toString(intent.getDoubleExtra("fat_mass",0));
        String  lean_mass_result =  Double.toString(intent.getDoubleExtra("lean_mass",0));




        bf_bmi.setText("Body Fat (BMI method): "+bf_bmi_result+"%");
        bf_navy.setText("Body Fat (US Navy method): "+bf_navy_result+"%");
        fat_mass.setText("Body Fat Mass: "+fat_mass_result+" kg");
        lean_mass.setText("Lean Body Mass: "+lean_mass_result+" kg");
    }
    private void roundDoubles(double number) {
        number*=10;
        number = Math.round(number);
        number= number/10;
    }
}
