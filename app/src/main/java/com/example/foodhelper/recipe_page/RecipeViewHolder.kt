package com.example.foodhelper.recipe_page

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvRecipeListBinding
import com.example.domain.models.instructions.InstructionsData

class RecipeViewHolder(
    private val binding: RvRecipeListBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun onBind(item: InstructionsData) {
        val equipmentRecycler = binding.rvEquipmentList
        val ingredientRecycler = binding.rvIngredientList

        val equipmentAdapter = RecipeInnerAdapter(false)
        equipmentRecycler.adapter = equipmentAdapter
        equipmentRecycler.layoutManager = GridLayoutManager(context, 4)
        equipmentAdapter.setInstructions(item.equipment)

        val ingredientAdapter = RecipeInnerAdapter(true)
        ingredientRecycler.adapter = ingredientAdapter
        ingredientRecycler.layoutManager = GridLayoutManager(context, 4)
        ingredientAdapter.setInstructions(item.ingredient)

        binding.numberTv.text = "Step ${item.number}"
        binding.stepTv.text = item.step
    }
}