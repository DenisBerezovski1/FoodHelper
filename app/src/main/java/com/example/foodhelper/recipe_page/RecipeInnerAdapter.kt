package com.example.foodhelper.recipe_page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvEquipmentIngredientListBinding
import com.example.domain.models.instructions.EquipmentIngredientData

class RecipeInnerAdapter(
    private val isIngredients: Boolean
) : RecyclerView.Adapter<RecipeInnerViewHolder>() {

    private val objectsList = mutableListOf<EquipmentIngredientData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeInnerViewHolder {
        val binding =
            RvEquipmentIngredientListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RecipeInnerViewHolder(binding, isIngredients)
    }

    override fun onBindViewHolder(holder: RecipeInnerViewHolder, position: Int) {
        holder.onBind(objectsList[position])
    }

    override fun getItemCount(): Int = objectsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setInstructions(list: List<EquipmentIngredientData>) {
        objectsList.clear()
        objectsList.addAll(list)
        notifyDataSetChanged()
    }
}