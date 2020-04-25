package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reduction_Calculator extends AppCompatActivity {
    TextView reduction_result;
    EditText curr_wgt;
    EditText curr_lean;
    EditText target_bf;
    EditText week_wgt_loss;
    Button summit;
    final double LBS = 0.45359237;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reduction_calculator);

        reduction_result = findViewById(R.id.reduction_result);
        curr_lean = findViewById(R.id.current_leanmass);
        target_bf = findViewById(R.id.bf_percent);
        week_wgt_loss = findViewById(R.id.weekWeigthLoss);
        curr_wgt = findViewById(R.id.current_weight);
        summit = findViewById(R.id.summitButton);
        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double reduct_wgt = getReductWeight();
                double reduct_time = getReductionTime();
                String text1 = Double.toString(reduct_wgt);
                String text2 = Double.toString(reduct_time);


                reduction_result.setText("Szacowana waga: "+ text1 + "       Szacowany czas: "+ text2+ " tygodni ");
            }
        });
    }

    public double getReductWeight(){
            double leanMass = Double.parseDouble(curr_lean.getText().toString());
            double targetBf = Double.parseDouble(target_bf.getText().toString());


            //Jednostka zmieniona na funty i przemnożona przez współczynnik utraty tkanki mięśniowej
            leanMass = (leanMass*LBS)*0.97;

            double result = ((leanMass)/(1-(targetBf/100))/LBS);

            result*=10;
            result = Math.round(result);
            result/=10;

        return result;

    }
    public double getReductionTime(){

        double reduct_weight = getReductWeight();
        double weekLoss =  Double.parseDouble(week_wgt_loss.getText().toString());
        double curr_weight = Double.parseDouble(curr_wgt.getText().toString());
        double result = ((curr_weight/LBS)-(reduct_weight/LBS))/(weekLoss/LBS);

        result*=10;
        result = Math.round(result);
        result/=10;

        return result;
    }

}
