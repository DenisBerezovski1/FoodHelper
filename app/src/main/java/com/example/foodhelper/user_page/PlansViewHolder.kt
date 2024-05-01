package com.example.foodhelper.user_page

import androidx.recyclerview.widget.RecyclerView
import com.example.foodhelper.databinding.RvPlansListBinding

class PlansViewHolder(
    private val binding: RvPlansListBinding,
    private val itemClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: String) {
        binding.planTv.text = item

        itemView.setOnClickListener {
            itemClick.invoke(item)
        }
    }
}