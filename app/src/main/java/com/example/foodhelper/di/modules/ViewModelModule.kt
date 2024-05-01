package com.example.foodhelper.di.modules

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelKey
import com.example.foodhelper.main_page.FoodViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FoodViewModel::class)
    fun bindLoginViewModel(viewModel: FoodViewModel): ViewModel
}