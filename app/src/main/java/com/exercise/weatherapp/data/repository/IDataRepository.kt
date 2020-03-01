package com.exercise.weatherapp.data.repository

import com.exercise.weatherapp.model.CurrentWeatherModel
import com.exercise.weatherapp.model.WeatherModel


interface IDataRepository {
    suspend fun getWeatherForecast(): UseCaseResult<WeatherModel>
    suspend fun getCurrentWeather(): UseCaseResult<CurrentWeatherModel>
   }