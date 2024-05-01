package com.example.foodhelper.generate_plan_page

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.food.FoodData
import com.example.domain.models.generate_template.GenerateMealsData
import com.example.foodhelper.databinding.RvMainFoodListBinding
import com.example.foodhelper.databinding.RvMealPlanListBinding

class MealPlanViewHolder(
    private val binding: RvMealPlanListBinding,
    private val itemClick: (String, String, String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun onBind(item: GenerateMealsData) {
        binding.mealItemTv.text = item.title
        binding.servingTv.text = "serving portions: " + item.servings.toString()
        binding.readyInTv.text = "ready in: " + item.readyInMinutes.toString() + " min"

        Glide
            .with(itemView)
            .load("https://spoonacular.com/recipeImages/${item.id}-312x231.${item.imageType}")
            .into(binding.mealImg)

        itemView.setOnClickListener {
            itemClick.invoke(item.id.toString(), item.imageType, item.title)
        }
    }
}