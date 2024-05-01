package com.example.foodhelper.main_page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvMainFoodListBinding
import com.example.domain.models.food.FoodData

class FoodAdapter(
    private val itemClick: (String, String, String) -> Unit
) : RecyclerView.Adapter<FoodViewHolder>() {

    private val foodList = mutableListOf<FoodData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding =
            RvMainFoodListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.onBind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setFood(list: List<FoodData>) {
        foodList.clear()
        foodList.addAll(list)
        notifyDataSetChanged()
    }
}