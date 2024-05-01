package com.example.foodhelper.generate_plan_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Repository
import com.example.domain.models.generate_template.GenerateTemplateData
import com.example.foodhelper.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

class GeneratePlanViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _generateTemplateLiveData = MutableLiveData<GenerateTemplateData>()
    val generateTemplateLiveData: LiveData<GenerateTemplateData> get() = _generateTemplateLiveData

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

    fun generateTemplate(
        timeFrame: String,
        targetCalories: String,
        diet: String,
        exclude: String,
        day: String
    ) {
        viewModelScope.launch(handler) {
            repository.weekTemplateToDB(timeFrame, targetCalories, diet, exclude)
            _generateTemplateLiveData.value = repository.generateDayTemplate(day)
        }
    }

    fun getDayTemplate(
        day: String
    ) {
        viewModelScope.launch(handler) {
            _generateTemplateLiveData.value = repository.generateDayTemplate(day)
        }
    }

    fun addPlan(plan: String) {
        viewModelScope.launch(handler) {
            repository.addPlanToDB(plan)
        }
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }
}