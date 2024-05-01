package com.example.foodhelper.user_page

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
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ViewModelFactory
import com.example.domain.models.generate_template.GenerateMealsData
import com.example.foodhelper.databinding.FragmentUserBinding
import com.example.foodhelper.FoodApp
import com.example.foodhelper.R
import com.example.foodhelper.databinding.AlertDialogBinding
import com.example.foodhelper.generate_plan_page.MealPlanAdapter
import java.util.*
import javax.inject.Inject

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: UserViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoodApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val plans = mutableListOf<String>()

        var currentPlan = 0
        val calendar = Calendar.getInstance()
        var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val days = resources.getStringArray(R.array.days)
        val daysSpinner = binding.daysSpinner

        daysSpinner.adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_dropdown_item,
                days
            )
        }
        daysSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                dayOfWeek = ((position - 1) % 7) + 2
                if (dayOfWeek == 8) dayOfWeek = 1
                if (position == 0) dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                viewModel.getCurrentPlan(plans[currentPlan], dayOfWeek)
                viewModel.getCurrentNutrients(plans[currentPlan], dayOfWeek)
                if (parent?.getChildAt(0) != null) {
                    val selectedView = parent.getChildAt(0) as TextView
                    selectedView.setTextColor(Color.BLACK)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                if (parent?.getChildAt(0) != null) {
                    val selectedView = parent.getChildAt(0) as TextView
                    selectedView.setTextColor(Color.BLACK)
                }
            }
        }

        val planItemClick: (String) -> Unit = { name ->
            var oldName = name
            var newName = oldName

            val builder = AlertDialog.Builder(requireContext())
            val dialogLayout = AlertDialogBinding.inflate(layoutInflater, null, false)
            builder.setView(dialogLayout.root)
            val alertDialog = builder.create()

            dialogLayout.editPlanName.hint = oldName
            dialogLayout.changeBt.setOnClickListener {
                newName = dialogLayout.editPlanName.text.toString()
                if (plans.indexOf(oldName) != -1) plans[plans.indexOf(oldName)] = newName
                viewModel.changePlanName(oldName, newName)
                oldName = newName
            }

            dialogLayout.setCurrentBt.setOnClickListener {
                currentPlan = plans.indexOf(newName)
                viewModel.getPlans()
            }

            dialogLayout.deletePlanBt.setOnClickListener {
                viewModel.deletePlan(newName)
                if (currentPlan >= plans.indexOf(newName)) currentPlan--

                plans.remove(newName)
                viewModel.getPlans()
            }
            alertDialog.show()
        }

        val mealItemClick: (String, String, String) -> Unit = { id, image, name ->
            val action = UserFragmentDirections.actionUserFragmentToRecipeFragment(id, image, name)
            findNavController().navigate(action)
        }

        val plansAdapter = PlansAdapter(planItemClick)
        val plansRecycler = binding.rvPlansList
        plansRecycler.adapter = plansAdapter
        plansRecycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        val mealsAdapter = MealPlanAdapter(mealItemClick)
        val mealsRecycler = binding.rvCurrentMeals
        mealsRecycler.adapter = mealsAdapter
        mealsRecycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        var oldCurrent = ""
        var wasPlanEmpty: Boolean
        viewModel.plansLiveData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.currentConstr.visibility = View.GONE
                binding.emptyLottieView.visibility = View.VISIBLE
                binding.plansTv.visibility = View.GONE
            } else {
                binding.currentConstr.visibility = View.VISIBLE
                binding.plansTv.visibility = View.VISIBLE
                binding.loadLottieView.visibility = View.GONE
            }
            if (plans.size != 0) {
                oldCurrent = plans[currentPlan]
                wasPlanEmpty = false
            } else wasPlanEmpty = true
            plans.clear()
            plans.addAll(it)
            currentPlan = if (!wasPlanEmpty) plans.indexOf(oldCurrent) else 0
            plansAdapter.setPlans(plans)
            binding.currentPlanNameTv.text = it[currentPlan]
            viewModel.getCurrentPlan(plans[currentPlan], dayOfWeek)
            viewModel.getCurrentNutrients(plans[currentPlan], dayOfWeek)
        }

        val mealsList = mutableListOf<GenerateMealsData>()

        viewModel.currentPlanLiveData.observe(viewLifecycleOwner) {
            mealsList.clear()
            mealsList.addAll(it.map { dayPlan ->
                GenerateMealsData(
                    dayPlan.id,
                    dayPlan.title,
                    dayPlan.readyInMinutes,
                    dayPlan.servings,
                    dayPlan.sourceUrl,
                    dayPlan.imageType
                )
            })
            mealsAdapter.setFood(mealsList)
        }

        viewModel.currentNutrientsLiveData.observe(viewLifecycleOwner) {
            binding.caloriesAmount.text = it.calories.toString()
            binding.carbohydratesAmount.text = it.carbohydrates.toString()
            binding.fatAmount.text = it.fat.toString()
            binding.proteinAmount.text = it.protein.toString()
        }

        viewModel.getPlans()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}