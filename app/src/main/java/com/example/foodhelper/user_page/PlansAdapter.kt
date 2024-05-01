package com.example.foodhelper.user_page

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvPlansListBinding

class PlansAdapter(
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<PlansViewHolder>() {

    private val plansList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlansViewHolder {
        val binding =
            RvPlansListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlansViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: PlansViewHolder, position: Int) {
        holder.onBind(plansList[position])
    }

    override fun getItemCount(): Int = plansList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setPlans(list: List<String>) {
        plansList.clear()
        plansList.addAll(list)
        notifyDataSetChanged()
    }
}