package com.example.pjatkpamo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeigth;
    private EditText editTextWeigth;
    private Button buttonCalculate;
    private TextView textViewCalculate;
    private double Bmi;
    private String formatedBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeigth = findViewById(R.id.editTextHeigth);
        editTextWeigth = findViewById(R.id.editTextWeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewCalculate = findViewById(R.id.textViewCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                double height = Double.parseDouble(editTextHeigth.getText().toString());
                double weight = Double.parseDouble(editTextWeigth.getText().toString());

                height = height / 100;

                Bmi =  weight / (Math.pow(height, 2));

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                formatedBmi = decimalFormat.format(Bmi);

                textViewCalculate.setText(formatedBmi);
            }
        });
    }
}