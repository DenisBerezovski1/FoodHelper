package com.example.foodhelper.nutrition_page

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodhelper.databinding.FragmentNutritionBinding
import com.example.foodhelper.FoodApp

class NutritionFragment : Fragment() {

    private val args: NutritionFragmentArgs by navArgs()
    private var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoodApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipeId = args.foodId
        binding.RecipeNameNutr.text = args.recipeName

        Glide
            .with(view)
            .load("https://spoonacular.com/recipeImages/${recipeId}-312x231.${args.image}")
            .into(binding.recipeImgNutr)

        Glide
            .with(view)
            .load("https://api.spoonacular.com/recipes/${recipeId}/nutritionLabel.png?apiKey=cb44a8ae583449e59d2f9e1974e55a5c")
            .into(binding.nutritionImg)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}