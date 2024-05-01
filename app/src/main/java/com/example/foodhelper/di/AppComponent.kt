package com.example.foodhelper.di

import android.content.Context
import com.example.foodhelper.di.modules.*
import com.example.foodhelper.generate_plan_page.GeneratePlanFragment
import com.example.foodhelper.main_page.FoodMainFragment
import com.example.foodhelper.nutrition_page.NutritionFragment
import com.example.foodhelper.recipe_page.RecipeFragment
import com.example.foodhelper.search_page.SearchFoodFragment
import com.example.foodhelper.user_page.UserFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class,
        SearchViewModelModule::class, RecipeViewModelModule::class, UserViewModelModule::class,
        GeneratePlanViewModelModule::class, SourceModule::class, DataBaseModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: FoodMainFragment)

    fun inject(fragment: SearchFoodFragment)

    fun inject(fragment: RecipeFragment)

    fun inject(fragment: NutritionFragment)

    fun inject(fragment: UserFragment)

    fun inject(fragment: GeneratePlanFragment)

}