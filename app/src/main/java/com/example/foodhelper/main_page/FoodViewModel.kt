package com.example.foodhelper.main_page

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

class FoodViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _foodLiveData = MutableLiveData<List<FoodData>>()
    val foodLiveData: LiveData<List<FoodData>> get() = _foodLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _noInternetLiveData = MutableLiveData<Boolean>()
    val noInternetLiveData: LiveData<Boolean> get() = _noInternetLiveData

    private val handler = CoroutineExceptionHandler { _, throwable: Throwable ->
        viewModelScope.launch {
            println(throwable.message)
            _noInternetLiveData.value = true
            _foodLiveData.value = repository.getBreakfastList("", false)

            when (throwable) {
                is SocketTimeoutException -> {
                    _errorLiveData.value = R.string.socketTimeout
                }
                else -> _errorLiveData.value = R.string.exception
            }
        }
    }

    fun getBreakfastList(query: String) {
        viewModelScope.launch(handler) {
            _noInternetLiveData.value = false
            _foodLiveData.value =
                if (repository.getBreakfastUpdate()) repository.getBreakfastList(query, false)
                else repository.getBreakfastList(query, !(noInternetLiveData.value ?: false))
        }
        repository.setBreakfastUpdate(false)
    }

    fun getBrunchList(query: String) {
        viewModelScope.launch(handler) {
            _noInternetLiveData.value = false
            _foodLiveData.value =
                if (repository.getBrunchUpdate()) repository.getBrunchList(query, false)
                else repository.getBrunchList(query, !(noInternetLiveData.value ?: false))
        }
        repository.setBrunchUpdate(true)
    }

    fun getLunchList(query: String) {
        viewModelScope.launch(handler) {
            _noInternetLiveData.value = false
            _foodLiveData.value =
                if (repository.getLunchUpdate()) repository.getLunchList(query, false)
                else repository.getLunchList(query, !(noInternetLiveData.value ?: false))
        }
        repository.setLunchUpdate(true)
    }

    fun getDinnerList(query: String) {
        viewModelScope.launch(handler) {
            _noInternetLiveData.value = false
            _foodLiveData.value =
                if (repository.getDinnerUpdate()) repository.getDinnerList(query, false)
                else repository.getDinnerList(query, !(noInternetLiveData.value ?: false))
        }
        repository.setDinnerUpdate(true)
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }
}