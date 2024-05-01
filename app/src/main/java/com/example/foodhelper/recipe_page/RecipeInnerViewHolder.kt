package com.example.foodhelper.recipe_page

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodhelper.databinding.RvEquipmentIngredientListBinding
import com.example.domain.models.instructions.EquipmentIngredientData

class RecipeInnerViewHolder(
    private val binding: RvEquipmentIngredientListBinding,
    private val isIngredients: Boolean
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: EquipmentIngredientData) {
        binding.objectTv.text = item.name
        val imageUrl =
            if (isIngredients) "https://spoonacular.com/cdn/ingredients_100x100/" + item.image
            else "https://spoonacular.com/cdn/equipment_100x100/" + item.image
        Glide
            .with(itemView)
            .load(imageUrl)
            .into(binding.objectImg)
    }
}