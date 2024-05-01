package com.example.foodhelper.di.modules

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelKey
import com.example.foodhelper.search_page.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindLoginViewModel(viewModel: SearchViewModel): ViewModel
}