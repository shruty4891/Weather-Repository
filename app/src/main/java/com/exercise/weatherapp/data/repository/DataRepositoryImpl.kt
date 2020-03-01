package com.exercise.weatherapp.data.repository

import com.exercise.weatherapp.data.network.WeatherApi
import com.exercise.weatherapp.model.CurrentWeatherModel
import com.exercise.weatherapp.model.WeatherModel

class DataRepositoryImpl(val api: WeatherApi) : IDataRepository {
    override suspend fun getWeatherForecast(): UseCaseResult<WeatherModel> {
        return try {
            val result = api.getWeatherForecast()
            if (result.isSuccessful)
                UseCaseResult.Success(result.body() as WeatherModel)
            else UseCaseResult.Error(RuntimeException("test error"))
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

    override suspend fun getCurrentWeather(): UseCaseResult<CurrentWeatherModel> {
        return try {
            val result = api.getCurrentWeather()
            if (result.isSuccessful)
                UseCaseResult.Success(result.body() as CurrentWeatherModel)
            else UseCaseResult.Error(RuntimeException("test error"))
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}

