package com.example.foodhelper.generate_plan_page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.generate_template.GenerateMealsData
import com.example.foodhelper.databinding.RvMealPlanListBinding

class MealPlanAdapter(
    private val itemClick: (String, String, String) -> Unit
) : RecyclerView.Adapter<MealPlanViewHolder>() {

    private val mealPlanList = mutableListOf<GenerateMealsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanViewHolder {
        val binding =
            RvMealPlanListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealPlanViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: MealPlanViewHolder, position: Int) {
        holder.onBind(mealPlanList[position])
    }

    override fun getItemCount(): Int = mealPlanList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setFood(list: List<GenerateMealsData>) {
        mealPlanList.clear()
        mealPlanList.addAll(list)
        notifyDataSetChanged()
    }
}