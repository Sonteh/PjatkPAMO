package com.example.pjatkpamo;

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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class CovidQuizFragment extends Fragment {

    Button answer1, answer2, answer3, answer4;
    TextView score, question;

    private final Questions Questions = new Questions();

    private String Answer;
    private int Score = 0;
    private final int QuestionLength = Questions.Questions.length;

    Random r;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        View view = inflater.inflate(R.layout.fragment_covid_quiz, container, false);

        r = new Random();

        answer1 = (Button) view.findViewById(R.id.answer1);
        answer2 = (Button) view.findViewById(R.id.answer2);
        answer3 = (Button) view.findViewById(R.id.answer3);
        answer4 = (Button) view.findViewById(R.id.answer4);

        score = (TextView) view.findViewById(R.id.score);
        question = (TextView) view.findViewById(R.id.question);

        score.setText("Score: " + Score);

        updateQuestion(r.nextInt(QuestionLength));

        answer1.setOnClickListener(v -> {
            if(answer1.getText().toString().equals(Answer)){
                Score++;
                score.setText("Score: " + Score);
                updateQuestion(r.nextInt(QuestionLength));
            }
            else {
                gameOver();
                Navigation.findNavController(view).navigate(R.id.action_covid_Quiz_Fragment_to_startingFragment);
            }
        });

        answer2.setOnClickListener(v -> {
            if(answer2.getText().toString().equals(Answer)){
                Score++;
                score.setText("Score: " + Score);
                updateQuestion(r.nextInt(QuestionLength));
            }
            else {
                gameOver();
                Navigation.findNavController(view).navigate(R.id.action_covid_Quiz_Fragment_to_startingFragment);
            }
        });

        answer3.setOnClickListener(v -> {
            if(answer3.getText().toString().equals(Answer)){
                Score++;
                score.setText("Score: " + Score);
                updateQuestion(r.nextInt(QuestionLength));
            }
            else {
                gameOver();
                Navigation.findNavController(view).navigate(R.id.action_covid_Quiz_Fragment_to_startingFragment);
            }
        });

        answer4.setOnClickListener(v -> {
            if(answer4.getText().toString().equals(Answer)){
                Score++;
                score.setText("Score: " + Score);
                updateQuestion(r.nextInt(QuestionLength));
            }
            else {
                gameOver();
                Navigation.findNavController(view).navigate(R.id.action_covid_Quiz_Fragment_to_startingFragment);
            }
        });

        return view;
    }

    private void updateQuestion(int num) {
        question.setText(Questions.getQuestion(num));
        answer1.setText(Questions.getAnswer1(num));
        answer2.setText(Questions.getAnswer2(num));
        answer3.setText(Questions.getAnswer3(num));
        answer4.setText(Questions.getAnswer4(num));

        Answer = Questions.getCorrectAnswer(num);
    }


    private void gameOver() {

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
        Context context = requireActivity().getApplicationContext();
        Toast toast = Toast.makeText(context,"Game Over!",Toast.LENGTH_SHORT);
        toast.show();
    }

}