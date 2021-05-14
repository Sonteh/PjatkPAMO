package com.example.pjatkpamo

import android.content.Context;
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf

import kotlin.math.pow

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_calculator, container, false)


        val editTextHeight: EditText = view.findViewById(R.id.editTextHeigth)
        val editTextWeight: EditText = view.findViewById(R.id.editTextWeight)
        val textViewCalculate: TextView = view.findViewById(R.id.textViewCalculate)
        val textViewCalculatedOpinion: TextView = view.findViewById(R.id.textViewCalculatedOpinion)
        val radioGroupSex: RadioGroup = view.findViewById(R.id.radioGroupSex)
        val textViewCalories: TextView = view.findViewById(R.id.textViewCalories)
        val editTextNumberAge: EditText = view.findViewById(R.id.editTextNumberAge)

        val buttonRecipe: Button = view.findViewById(R.id.buttonRecipe)
        val buttonCalculate: Button = view.findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val height = editTextDoubleParser(editTextHeight)
            val weight = editTextDoubleParser(editTextWeight)

            val bmi = calculate(height, weight)

            //if (height == 0.0) {
            //    return
            //}

            textViewCalculate.text = formatter(bmi).toString()

            bmi(textViewCalculatedOpinion, bmi)

            val selectedId = radioGroupSex.checkedRadioButtonId;
            val selectedRadioButton: RadioButton = view.findViewById(selectedId)
            val selectedRbText: String = selectedRadioButton.text.toString()

            val age = editTextIntParser(editTextNumberAge);

            //if (age == 0.0) {
            //    return;
            //}

            howManyCalories(textViewCalories, selectedRbText, height, weight, age);
            buttonRecipe.visibility = View.VISIBLE;

            val result = Bundle()
            result.putDouble("bundledKey", bmi)
            parentFragmentManager.setFragmentResult("requestKey", result)
        }

        buttonRecipe.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_calculatorFragment_to_recipeFragment)
        }

        return view
    }

    private fun editTextDoubleParser(editText: EditText): Double {
        try
        {
            return editText.text.toString().toDouble()
        }
        catch (e: NumberFormatException)
        {
            val context: Context = requireActivity().applicationContext
            val toast: Toast = Toast.makeText(context,"No value provided!",Toast.LENGTH_SHORT)
            toast.show()
            return 0.0
        }
    }

    fun editTextIntParser(editText: EditText): Double {
        try
        {
            return editText.text.toString().toDouble()
        }
        catch (e: NumberFormatException)
        {
            val context: Context = requireActivity().applicationContext
            val toast: Toast  = Toast.makeText(context,"No value provided!",Toast.LENGTH_SHORT)
            toast.show()
            return 0.0
        }
    }

    private fun calculate(height: Double, weight: Double): Double {

        if(height == 0.0)
        {
            val context: Context = requireActivity().applicationContext;
            val toast: Toast = Toast.makeText(context,"Height can't be 0!", Toast.LENGTH_SHORT);
            toast.show()
            return 0.0
        }

        val height2 = height / 100;
        return weight / (height2.pow(2.0));
    }

    fun formatter(Bmi: Double): Double {

        return "%.2f".format(Bmi).toDouble()
    }

    fun bmi(textViewCalculatedOpinion: TextView, Bmi: Double){

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

    fun howManyCalories(textViewCalories: TextView, selectedRbButton: String, height: Double, weight: Double, age: Double){

        val calories: Double

        if(selectedRbButton == "Man")
        {
            calories = (66.47f + 13.7f * weight + 5.0f * height - 6.76f * age)
            textViewCalories.text = formatter(calories).toString()
            return
        }

        calories = (655.1f + 9.567f * weight + 1.85f * height - 4.68f * age)
        textViewCalories.text = formatter(calories).toString()
    }
}