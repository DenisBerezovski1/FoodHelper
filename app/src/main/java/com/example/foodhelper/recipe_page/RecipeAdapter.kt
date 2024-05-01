package com.example.foodhelper.recipe_page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvRecipeListBinding
import com.example.domain.models.instructions.InstructionsData

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {

    private val instructionsList = mutableListOf<InstructionsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            RvRecipeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.onBind(instructionsList[position])
    }

    override fun getItemCount(): Int = instructionsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setInstructions(list: List<InstructionsData>) {
        instructionsList.clear()
        instructionsList.addAll(list)
        notifyDataSetChanged()
    }
}