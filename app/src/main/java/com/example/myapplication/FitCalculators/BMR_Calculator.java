package com.example.myapplication.FitCalculators;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;


public class BMR_Calculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit_button;
    private EditText ageText;
    private EditText weightText;
    private EditText heightText;
    private Spinner spinnerPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmr_calculator);

        ageText = findViewById(R.id.ageEditText);
        weightText = findViewById(R.id.weightEditText);
        heightText = findViewById(R.id.heightEditText);
        submit_button = findViewById(R.id.submit_button);
        radioGroup = findViewById(R.id.radioGroup);



        //spinnerPA = findViewById(R.id.spinner1);
        //ArrayAdapter<CharSequence> adapterPA = ArrayAdapter.createFromResource(BMR_Calculator.this,activity_level);
        //adapterPA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerPA.setAdapter(adapterPA);
        //spinnerPA.setOnItemSelectedListener(this);


        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(ageText.getText().toString().equals("")||
                        weightText.getText().toString().equals("")||
                        heightText.getText().toString().equals(""))
                    Toast.makeText(BMR_Calculator.this, "Uzupełnij puste pola",Toast.LENGTH_SHORT);
                else
                {    int bmr = (int) Math.floor(bmr_calculator());
                    int cpm = (int) Math.floor(cpmCalculator());
                    int cpm_lose  = cpm - 300;
                    int cpm_grow = cpm + 300;


                    Intent intent = new Intent(BMR_Calculator.this, BMR_Result.class);

                    intent.putExtra("BMR",bmr);
                    intent.putExtra("CPM",cpm);
                    intent.putExtra("CPM_lose",cpm_lose);
                    intent.putExtra("CPM_grow",cpm_grow);
                    startActivityForResult(intent,1);
                }
            }
        });

    }
    private double roundDoubles(double number) {
        number*=10;
        number = Math.round(number);
        number= number/10;
        return number;
    }

    private double cpmCalculator() {
        double bmr = bmr_calculator();
        String activity_level = spinnerPA.getSelectedItem().toString();

        if (activity_level.equals("Brak aktywności fizycznej")) {
            bmr *= 1.2;
            bmr = roundDoubles(bmr);
        } else if (activity_level.equals("Niska aktywność, praca siedząca i 1-2 treningi w tygodniu")) {
            bmr *= 1.35;
            bmr = roundDoubles(bmr);
        } else if (activity_level.equals("Srednia aktywność, trening około 3-4 razy w tygodniu")) {
            bmr *= 1.55;
            bmr = roundDoubles(bmr);
        } else if (activity_level.equals("Wzmożona aktywność, trening 4-5 razy w tygodniu")) {
            bmr *= 1.75;
            bmr = roundDoubles(bmr);
        } else if (activity_level.equals("Bardzo wysoka aktywność fizyczna, 5 i więcej treningów w tygodniu")) {
            bmr *= 2.05;
            bmr = roundDoubles(bmr);
        }
        return bmr;

    }
    private double bmr_calculator() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String gender = (String) radioButton.getText();

        if(gender.equals("Mężczyzna")) {
            double bmr_male = bmrCalculatorMale();
            return bmr_male;
        }
        else {
            double bmr_female = bmrCalculatorFemale();
            return bmr_female;
        }
    }

    private double bmrCalculatorFemale()
    {
        double weight  = Double.parseDouble(weightText.getText().toString());
        double height = Double.parseDouble(heightText.getText().toString());
        double age = Double.parseDouble(ageText.getText().toString());
        double count =
                (9.99 * weight) + (6.25 * height) - (4.92 * age) - 161;

        count= roundDoubles(count);
        return count;
    }

    private double bmrCalculatorMale()
    {

        double weight  = Double.parseDouble(weightText.getText().toString());
        double height = Double.parseDouble(heightText.getText().toString());
        double age = Double.parseDouble(ageText.getText().toString());
        double count =
                (9.99 * weight) + (6.25 * height) - (4.92 * age) + 5;

        count = roundDoubles(count);
        return count;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
