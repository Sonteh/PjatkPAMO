package com.example.pjatkpamo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_starting, container, false);

        Button calculatorBmi = view.findViewById(R.id.Calculator_BMI_button);
        Button covidGraph = view.findViewById(R.id.Covid_Graph_button);
        Button covidQuiz = view.findViewById(R.id.Covid_Quiz_button);

        calculatorBmi.setOnClickListener(bmi -> {
            Navigation.findNavController(view).navigate(R.id.action_startingFragment_to_calculatorFragment);
        });

        covidGraph.setOnClickListener(graph -> {
            Navigation.findNavController(view).navigate(R.id.action_startingFragment_to_covidGraphFragment);
        });

        covidQuiz.setOnClickListener(quiz -> {
            Navigation.findNavController(view).navigate(R.id.action_startingFragment_to_covid_Quiz_Fragment);
        });

        return view;
    }

}