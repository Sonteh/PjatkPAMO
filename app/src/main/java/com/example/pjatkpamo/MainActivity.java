package com.example.pjatkpamo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWeight;
    private TextView textViewCalculate;
    private TextView textViewCalcultedOpinion;
    private double Bmi;
    private String formatedBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeigth);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewCalculate = findViewById(R.id.textViewCalculate);
        textViewCalcultedOpinion = findViewById(R.id.textViewCalculatedOpinion);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(view -> {
            double height = Double.parseDouble(editTextHeight.getText().toString());
            double weight = Double.parseDouble(editTextWeight.getText().toString());

            height = height / 100;

            Bmi =  weight / (Math.pow(height, 2));

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            formatedBmi = decimalFormat.format(Bmi);

            textViewCalculate.setText(formatedBmi);

            if(Bmi < 18.5f)
            { ;
                textViewCalcultedOpinion.setText(R.string.Underweight);
            }
            else if(Bmi >= 18.5f && Bmi < 25.0f)
            {
                textViewCalcultedOpinion.setText(R.string.Optimum);
            }
            else if(Bmi >= 25.0f && Bmi < 30.0f)
            {
                textViewCalcultedOpinion.setText(R.string.Overweight);
            }
            else
            {
                textViewCalcultedOpinion.setText(R.string.Obesity);
            }

        });
    }
}