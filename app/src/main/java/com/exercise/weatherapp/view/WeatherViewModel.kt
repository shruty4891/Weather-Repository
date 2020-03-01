package com.exercise.weatherapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exercise.weatherapp.data.repository.IDataRepository
import com.exercise.weatherapp.data.repository.UseCaseResult
import com.exercise.weatherapp.model.CurrentWeatherModel
import com.exercise.weatherapp.model.WeatherModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class WeatherViewModel(private val dataRepository: IDataRepository) : ViewModel(),
    CoroutineScope {
    private val job = Job()
    val list = MutableLiveData<WeatherModel>()
    val currentWeatherModel = MutableLiveData<CurrentWeatherModel>()
    val isInternetGone = MutableLiveData<Boolean>()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun getWeatherInfo() {
        val r = async { getTodayWeather() }
        val b = async { getWeatherForcast() }
    }

    private suspend fun getTodayWeather() {
        CoroutineScope(coroutineContext).launch {
            when (val result = withContext(Dispatchers.IO) { dataRepository.getCurrentWeather() }) {
                is UseCaseResult.Success -> {
                    currentWeatherModel.value = result.data
                    isInternetGone.value = false
                }
                is UseCaseResult.Error ->
                    isInternetGone.value = true
            }
        }
    }

    private suspend fun getWeatherForcast() {
        CoroutineScope(coroutineContext).launch {
            when (val result =
                withContext(Dispatchers.IO) { dataRepository.getWeatherForecast() }) {
                is UseCaseResult.Success -> {
                    list.value = result.data
                    isInternetGone.value = false
                }
                is UseCaseResult.Error ->
                    isInternetGone.value = true
            }
        }
    }
}