package com.example.pjatkpamo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener


class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_recipe, container, false)

        parentFragmentManager.setFragmentResultListener("requestKey", this,
            FragmentResultListener { requestKey, bundle ->
                val result = bundle.getDouble("bundledKey")
                val textViewRecipe = view.findViewById<TextView>(R.id.textViewRecipe)

                if (result < 25.0f) {
                    textViewRecipe.text = getString(R.string.recipe_high_calories)
                    return@FragmentResultListener
                }

                textViewRecipe.text = getString(R.string.recipe_low_calories)
            })

        return view
    }

}