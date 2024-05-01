package com.example.foodhelper.search_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodhelper.R
import com.example.domain.Repository
import com.example.domain.models.food.FoodData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _searchLiveData = MutableLiveData<List<FoodData>>()
    val searchLiveData: LiveData<List<FoodData>> get() = _searchLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _noInternetLiveData = MutableLiveData<Boolean>()
    private val noInternetLiveData: LiveData<Boolean> get() = _noInternetLiveData

    private val handler = CoroutineExceptionHandler { _, throwable: Throwable ->
        viewModelScope.launch {
            _noInternetLiveData.value = true
            when (throwable) {
                is SocketTimeoutException -> {
                    _errorLiveData.value = R.string.socketTimeout
                }
                else -> _errorLiveData.value = R.string.exception
            }
        }
    }

    private val searchDebouncer = Debouncer(1000)

    fun getFoodList(query: String, cuisine: String, diet: String, intolerance: String) {
        searchDebouncer.debounce {
            viewModelScope.launch(handler) {
                _noInternetLiveData.value = false
                _searchLiveData.value =
                    repository.getFoodList(
                        query,
                        cuisine,
                        diet,
                        intolerance,
                        !(noInternetLiveData.value ?: false)
                    )
            }
        }
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }
}