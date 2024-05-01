package com.example.foodhelper.recipe_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodhelper.R
import com.example.domain.Repository
import com.example.domain.models.instructions.InstructionsData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

class RecipeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _instructionsLiveData = MutableLiveData<List<InstructionsData>>()
    val instructionsLiveData: LiveData<List<InstructionsData>> get() = _instructionsLiveData

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

    fun getInstructionsList(id: String) {
        viewModelScope.launch(handler) {
            _noInternetLiveData.value = false
            _instructionsLiveData.value =
                repository.getInstructionsList(id, !(noInternetLiveData.value ?: false))
        }
    }

    fun setToken(token: String) {
        repository.setToken(token)
    }
}