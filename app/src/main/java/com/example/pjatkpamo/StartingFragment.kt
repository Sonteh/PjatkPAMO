package com.example.pjatkpamo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class StartingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_starting, container, false)

        val calculatorBmi: Button = view.findViewById(R.id.Calculator_BMI_button)
        val covidGraph: Button = view.findViewById(R.id.Covid_Graph_button)
        val covidQuiz: Button = view.findViewById(R.id.Covid_Quiz_button)

        calculatorBmi.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_startingFragment_to_calculatorFragment)
        }

        covidGraph.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_startingFragment_to_covidGraphFragment)
        }

        covidQuiz.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_startingFragment_to_covidQuizFragment)
        }

        return view
    }
}