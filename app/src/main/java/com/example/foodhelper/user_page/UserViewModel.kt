package com.example.foodhelper.user_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Repository
import com.example.domain.models.generate_template.NutrientsTemplateData
import com.example.domain.models.user.DayPlanData
import com.example.foodhelper.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _plansLiveData = MutableLiveData<List<String>>()
    val plansLiveData: LiveData<List<String>> get() = _plansLiveData

    private val _currentNutrientsLiveData = MutableLiveData<NutrientsTemplateData>()
    val currentNutrientsLiveData: LiveData<NutrientsTemplateData> get() = _currentNutrientsLiveData

    private val _currentPlanLiveData = MutableLiveData<List<DayPlanData>>()
    val currentPlanLiveData: LiveData<List<DayPlanData>> get() = _currentPlanLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val handler = CoroutineExceptionHandler { _, throwable: Throwable ->
        viewModelScope.launch {
            when (throwable) {
                is SocketTimeoutException -> {
                    _errorLiveData.value = R.string.socketTimeout
                }
                else -> _errorLiveData.value = R.string.exception
            }
        }
    }

    fun getPlans() {
        viewModelScope.launch(handler) {
            _plansLiveData.value = repository.getPlans()
        }
    }

    fun getCurrentPlan(planName: String, day: Int) {
        viewModelScope.launch(handler) {
            _currentPlanLiveData.value = repository.getCurrentPlan(planName, day)
        }
    }

    fun getCurrentNutrients(planName: String, day: Int) {
        viewModelScope.launch(handler) {
            _currentNutrientsLiveData.value = repository.getCurrentNutrients(planName, day)
        }
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }

    fun changePlanName(oldName: String, newName: String) {
        viewModelScope.launch(handler) {
            _plansLiveData.value = repository.changePlanName(oldName, newName)
        }
    }

    fun deletePlan(name: String) {
        viewModelScope.launch(handler) {
            _plansLiveData.value = repository.deletePlan(name)
        }
    }
}