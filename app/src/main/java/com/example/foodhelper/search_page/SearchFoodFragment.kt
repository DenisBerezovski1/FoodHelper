package com.example.foodhelper.search_page

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ViewModelFactory
import com.example.foodhelper.databinding.FragmentSearchFoodBinding
import com.example.domain.models.food.FoodData
import com.example.foodhelper.FoodApp
import com.example.foodhelper.R
import com.example.foodhelper.databinding.FiltersDialogBinding
import com.example.foodhelper.main_page.FoodAdapter
import javax.inject.Inject

class SearchFoodFragment : Fragment() {

    private var _binding: FragmentSearchFoodBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: SearchViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoodApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = binding.rvSearchList
        val editText = binding.searchText

        val itemClick: (String, String, String) -> Unit = { id, image, name ->
            val action = SearchFoodFragmentDirections.actionSearchFoodFragmentToRecipeFragment(
                id,
                image,
                name
            )
            findNavController().navigate(action)
        }

        val adapter = FoodAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        val foodList = mutableListOf<FoodData>()

        var query: String
        var cuisine = ""
        var diet = ""
        var intolerance = ""
        editText.addTextChangedListener { text ->
            binding.emptyLottieView.visibility = View.GONE
            query = text.toString()
            val food = if (query != "") {
                viewModel.getFoodList(query, cuisine, diet, intolerance)
                binding.lottieView.visibility = View.VISIBLE
                foodList
            } else {
                binding.lottieView.visibility = View.VISIBLE
                emptyList()
            }
            adapter.setFood(food)
        }

        binding.filterBt.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val dialogLayout = FiltersDialogBinding.inflate(layoutInflater, null, false)
            builder.setView(dialogLayout.root)
            val alertDialog = builder.create()

            dialogLayout.cuisineBt.setOnClickListener {
                val cuisines = resources.getStringArray(R.array.cuisines)
                var selectedItem = 0
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Choose element")
                builder.setSingleChoiceItems(cuisines, selectedItem) { _, which ->
                    selectedItem = which
                }

                builder.setPositiveButton("Ok") { _, _ ->
                    dialogLayout.cuisineTv.text = cuisines[selectedItem]
                    cuisine = cuisines[selectedItem]
                }

                val dialog = builder.create()
                dialog.show()
            }

            dialogLayout.dietBt.setOnClickListener {
                val diets = resources.getStringArray(R.array.diets)
                var selectedItem = 0

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Choose element")
                builder.setSingleChoiceItems(diets, selectedItem) { _, which ->
                    selectedItem = which
                }

                builder.setPositiveButton("Ok") { _, _ ->
                    dialogLayout.dietTv.text = diets[selectedItem]
                    diet = diets[selectedItem]
                }

                val dialog = builder.create()
                dialog.show()
            }

            dialogLayout.intolerancesBt.setOnClickListener {
                val intolerances = resources.getStringArray(R.array.intolerances)
                var selectedItem = 0

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Choose element")
                builder.setSingleChoiceItems(intolerances, selectedItem) { _, which ->
                    selectedItem = which
                }

                builder.setPositiveButton("Ok") { _, _ ->
                    dialogLayout.intolerancesTv.text = intolerances[selectedItem]
                    intolerance = intolerances[selectedItem]
                }

                val dialog = builder.create()
                dialog.show()
            }

            alertDialog.show()
        }

        viewModel.searchLiveData.observe(viewLifecycleOwner) {
            binding.lottieView.visibility = View.GONE
            if (it.isEmpty()) binding.emptyLottieView.visibility = View.VISIBLE
            foodList.clear()
            foodList.addAll(it)
            adapter.setFood(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}