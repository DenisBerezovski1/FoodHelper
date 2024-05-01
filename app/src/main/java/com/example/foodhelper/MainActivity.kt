package com.example.foodhelper

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodhelper.databinding.ActivityMainBinding
import com.example.foodhelper.generate_plan_page.GeneratePlanFragment
import com.example.foodhelper.main_page.FoodMainFragment
import com.example.foodhelper.search_page.SearchFoodFragment
import com.example.foodhelper.user_page.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_fragments)
        navView.setupWithNavController(navController)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController(R.id.nav_fragments).popBackStack()
            }
        })

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.mainFragment)
                    true
                }
                R.id.navigation_search -> {
                    navController.navigate(R.id.searchFoodFragment)
                    true
                }
                R.id.navigation_add_meal -> {
                    navController.navigate(R.id.generatePlanFragment)
                    true
                }
                R.id.navigation_user -> {
                    navController.navigate(R.id.userFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
        val colorStateList = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf()), intArrayOf(
                ContextCompat.getColor(this, R.color.light_red),
                ContextCompat.getColor(this, R.color.white)
            )
        )
        bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        bottomNavigationView.itemIconTintList = colorStateList
        bottomNavigationView.itemTextColor = colorStateList

    }
}