package com.example.pjatkpamo

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class CovidQuizFragment : Fragment() {

    var answer1: Button? = null; var answer2: Button? = null
    var answer3: Button? = null; var answer4: Button? = null
    //var score: TextView? = null
    var question:TextView? = null

    private val Questions = Questions()

    private var Answer: String? = null
    private var Score: Int = 0
    private val QuestionLength: Int = Questions.Questions.size

    var r: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_covid_quiz, container, false);

        //r = (0..QuestionLength).random()

        answer1 = view.findViewById(R.id.answer1)
        answer2 = view.findViewById(R.id.answer2)
        answer3 = view.findViewById(R.id.answer3)
        answer4 = view.findViewById(R.id.answer4)

        val score: TextView = view.findViewById(R.id.score)
        question = view.findViewById(R.id.question)

        score.text = ("Score: $Score")

        updateQuestion((0..QuestionLength).random())

        answer1?.setOnClickListener {
            if(answer1?.text.toString() == Answer){
                Score++
                score.text = ("Score: " + Score)
                updateQuestion((0..QuestionLength).random())
            }
            else {
                gameOver()
                Navigation.findNavController(view).navigate(R.id.action_covidQuizFragment_to_startingFragment)
            }
        }

        answer2?.setOnClickListener {
            if(answer2?.text.toString() == Answer){
                Score++
                score.text = ("Score: " + Score)
                updateQuestion((0..QuestionLength).random())
            }
            else {
                gameOver()
                Navigation.findNavController(view).navigate(R.id.action_covidQuizFragment_to_startingFragment)
            }
        }

        answer3?.setOnClickListener {
            if(answer3?.text.toString() == Answer){
                Score++
                score.text = ("Score: " + Score)
                updateQuestion((0..QuestionLength).random())
            }
            else {
                gameOver()
                Navigation.findNavController(view).navigate(R.id.action_covidQuizFragment_to_startingFragment)
            }
        }

        answer4?.setOnClickListener {
            if(answer4?.text.toString() == Answer){
                Score++
                score.text = ("Score: " + Score)
                updateQuestion((0..QuestionLength).random())
            }
            else {
                gameOver()
                Navigation.findNavController(view).navigate(R.id.action_covidQuizFragment_to_startingFragment)
            }
        }

        return view;
    }

    private fun updateQuestion(num: Int) {
        question?.text = Questions.getQuestion(num)
        answer1?.text = Questions.getAnswer1(num)
        answer2?.text = Questions.getAnswer2(num)
        answer3?.text = Questions.getAnswer3(num)
        answer4?.text = Questions.getAnswer4(num)

        Answer = Questions.getCorrectAnswer(num)
    }


    private fun gameOver() {

        /*
        Context context = requireActivity().getApplicationContext();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage("GAME OVER! Your score is: " + Score)
                .setCancelable(false)
                .setPositiveButton("New game",
                        (dialog, which) -> startActivity(new Intent(requireActivity().getApplicationContext(), CovidQuizFragment.class)))
                .setNegativeButton("Exit",
                        (dialog, which) -> getActivity().finish());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        */
        val context: Context = requireActivity().applicationContext;
        val toast: Toast = Toast.makeText(context,"Game Over!",Toast.LENGTH_SHORT);
        toast.show();
    }
}