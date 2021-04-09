package com.example.pjatkpamo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class CalculatorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);


        EditText editTextHeight = view.findViewById(R.id.editTextHeigth);
        EditText editTextWeight = view.findViewById(R.id.editTextWeight);
        TextView textViewCalculate = view.findViewById(R.id.textViewCalculate);
        TextView textViewCalculatedOpinion = view.findViewById(R.id.textViewCalculatedOpinion);
        RadioGroup radioGroupSex = view.findViewById(R.id.radioGroupSex);
        TextView textViewCalories = view.findViewById(R.id.textViewCalories);
        EditText editTextNumberAge = view.findViewById(R.id.editTextNumberAge);

        Button buttonRecipe = view.findViewById(R.id.buttonRecipe);
        Button buttonCalculate = view.findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(navigation -> {
            double height = EditTextDoubleParser(editTextHeight);
            double weight = EditTextDoubleParser(editTextWeight);

            double Bmi =  Calculate(height, weight);

            if(height == 0) {
                return;
            }

            textViewCalculate.setText(Formatter(Bmi));

            Bmi(textViewCalculatedOpinion, Bmi);

            int selectedId = radioGroupSex.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = view.findViewById(selectedId);
            String selectedRbText = selectedRadioButton.getText().toString();

            int age = EditTextIntParser(editTextNumberAge);

            if(age == 0) {
                return;
            }

            HowManyCalories(textViewCalories, selectedRbText, height, weight, age);
            buttonRecipe.setVisibility(View.VISIBLE);

            Bundle result = new Bundle();
            result.putDouble("bundledKey", Bmi);
            getParentFragmentManager().setFragmentResult("requestKey", result);
        });



        buttonRecipe.setOnClickListener(navigation -> {
            Navigation.findNavController(view).navigate(R.id.action_calculatorFragment_to_recipeFragment);
        });

        return view;
    }

    double EditTextDoubleParser(EditText editText) {
        try
        {
            return Double.parseDouble(editText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Context context = requireActivity().getApplicationContext();
            Toast toast = Toast.makeText(context,"No value provided!",Toast.LENGTH_SHORT);
            toast.show();
            return 0;
        }
    }

    int EditTextIntParser(EditText editText) {
        try
        {
            return Integer.parseInt(editText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Context context = requireActivity().getApplicationContext();
            Toast toast = Toast.makeText(context,"No value provided!",Toast.LENGTH_SHORT);
            toast.show();
            return 0;
        }
    }

    double Calculate(double height, double weight){

        if(height == 0)
        {
            Context context = requireActivity().getApplicationContext();
            Toast toast = Toast.makeText(context,"Height can't be 0!", Toast.LENGTH_SHORT);
            toast.show();
            return 0;
        }

            height = height / 100;
            return weight / (Math.pow(height, 2));
    }

    static String Formatter(double Bmi){

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return decimalFormat.format(Bmi);
    }

     static void Bmi(TextView textViewCalculatedOpinion, double Bmi){

        if(Bmi < 18.5f)
        {
            textViewCalculatedOpinion.setText(R.string.Underweight);
        }
        else if(Bmi >= 18.5f && Bmi < 25.0f)
        {
            textViewCalculatedOpinion.setText(R.string.Optimum);
        }
        else if(Bmi >= 25.0f && Bmi < 30.0f)
        {
            textViewCalculatedOpinion.setText(R.string.Overweight);
        }
        else
        {
            textViewCalculatedOpinion.setText(R.string.Obesity);
        }
    }

    static void HowManyCalories(TextView textViewCalories, String selectedRbButton, double height, double weight, int age){

        double calories;

        if(selectedRbButton.equals("Man"))
        {
            calories = (66.47f + 13.7f * weight + 5.0f * height - 6.76f * age);
            textViewCalories.setText(Formatter(calories));
            return;
        }

        calories = (655.1f + 9.567f * weight + 1.85f * height - 4.68f * age);
        textViewCalories.setText(Formatter(calories));
    }
}