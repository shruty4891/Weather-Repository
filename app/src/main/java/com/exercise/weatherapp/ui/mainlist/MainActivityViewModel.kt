package com.exercise.weatherapp.ui.mainlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exercise.weatherapp.data.repository.IDataRepository
import com.exercise.weatherapp.data.repository.UseCaseResult
import com.exercise.weatherapp.model.WeatherModel
import com.shruti.demoproject.model.ListModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel(private val dataRepository: IDataRepository) : ViewModel(),
    CoroutineScope {
    private val job = Job()
    val list = MutableLiveData<WeatherModel>()
    val isShimmerGone = MutableLiveData<Boolean>()
    val isInternetGone = MutableLiveData<Boolean>()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    fun getWeatherForcast() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = withContext(Dispatchers.IO) { dataRepository.getWeatherForecast() }
            isShimmerGone.value = true
            when (result) {
                is UseCaseResult.Success -> {
                    list.value = result.data
                    isInternetGone.value = false
                }
                is UseCaseResult.Error ->
                    isInternetGone.value = true
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}