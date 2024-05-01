package com.example.foodhelper.main_page

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodhelper.databinding.RvMainFoodListBinding
import com.example.domain.models.food.FoodData

class FoodViewHolder(
    private val binding: RvMainFoodListBinding,
    private val itemClick: (String, String, String) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: FoodData) {
        binding.foodTv.text = item.title

        Glide
            .with(itemView)
            .load("https://spoonacular.com/recipeImages/${item.id}-312x231.${item.imageType}")
            .into(binding.foodImg)

        itemView.setOnClickListener {
            itemClick.invoke(item.id.toString(), item.imageType, item.title)
        }
    }
}