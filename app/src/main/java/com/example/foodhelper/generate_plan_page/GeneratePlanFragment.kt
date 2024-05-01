package com.example.foodhelper.generate_plan_page

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ViewModelFactory
import com.example.domain.models.generate_template.GenerateMealsData
import com.example.foodhelper.R
import com.example.foodhelper.databinding.FragmentGeneratePlanBinding
import com.example.foodhelper.FoodApp
import java.util.*
import javax.inject.Inject

class GeneratePlanFragment : Fragment() {

    private var _binding: FragmentGeneratePlanBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: GeneratePlanViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoodApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneratePlanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val timeFrame = "week"
        var plan = ""
        binding.planNameEdit.addTextChangedListener {
            plan = it.toString()
        }

        val days = resources.getStringArray(R.array.days)
        var day = ""
        val daysSpinner = binding.daysSpinner
        val calendar = Calendar.getInstance()
        var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        daysSpinner.adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_dropdown_item,
                days
            )
        }
        daysSpinner.dropDownVerticalOffset = 10
        daysSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    if (dayOfWeek == 1) dayOfWeek = 8
                    day = days[dayOfWeek - 1]
                } else day = days[position]
                viewModel.getDayTemplate(day)
                binding.lottieView.visibility = View.VISIBLE
                if (parent?.getChildAt(0) != null) {
                    val selectedView = parent.getChildAt(0) as TextView
                    selectedView.setTextColor(Color.BLACK)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                if (day == "") day = days[0]
                if (parent?.getChildAt(0) != null) {
                    val selectedView = parent.getChildAt(0) as TextView
                    selectedView.setTextColor(Color.BLACK)
                }
            }
        }

        var targetCalories = ""
        binding.targetCaloriesEdit.addTextChangedListener {
            targetCalories = it.toString()
        }

        val selectedDiet = binding.selectedDietTv
        binding.dietBt.setOnClickListener {
            val diets = resources.getStringArray(R.array.diets)
            var checkedItem = 0

            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Choose element")
            builder.setSingleChoiceItems(diets, checkedItem) { _, which ->
                checkedItem = which
            }

            builder.setPositiveButton("Ok") { _, _ ->
                selectedDiet.text = diets[checkedItem]
            }

            builder.setNegativeButton("Escape") { _, _ ->
            }

            val dialog = builder.create()
            dialog.show()
        }

        var exclude = ""
        binding.excludeEdit.addTextChangedListener {
            exclude = it.toString()
        }

        val itemClick: (String, String, String) -> Unit = { id, image, name ->
            val action = GeneratePlanFragmentDirections.actionGeneratePlanFragmentToRecipeFragment(
                id,
                image,
                name
            )
            findNavController().navigate(action)
        }

        val adapter = MealPlanAdapter(itemClick)
        val recycler = binding.rvMealPlanList
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        val mealsList = mutableListOf<GenerateMealsData>()

        viewModel.generateTemplateLiveData.observe(viewLifecycleOwner) {
            binding.lottieView.visibility = View.INVISIBLE
            mealsList.clear()
            mealsList.addAll(it.meals)
            adapter.setFood(mealsList)
            binding.caloriesAmount.text = it.nutrients.calories.toString()
            binding.carbohydratesAmount.text = it.nutrients.carbohydrates.toString()
            binding.fatAmount.text = it.nutrients.fat.toString()
            binding.proteinAmount.text = it.nutrients.protein.toString()
            binding.caloriesTv.isVisible = true
            binding.carbohydratesTv.isVisible = true
            binding.fatTv.isVisible = true
            binding.proteinTv.isVisible = true
            binding.mealPlanNutrientsTv.isVisible = true
        }

        binding.getPlanBt.setOnClickListener {
            binding.lottieView.visibility = View.VISIBLE
            viewModel.generateTemplate(
                timeFrame,
                targetCalories,
                selectedDiet.text.toString(),
                exclude,
                day
            )
        }
        binding.addPlanBt.setOnClickListener {
            if (plan != "") {
                viewModel.addPlan(plan)
                Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            } else Toast.makeText(requireContext(), "Enter plan name", Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}