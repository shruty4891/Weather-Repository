package com.exercise.weatherapp.data.repository

import com.exercise.weatherapp.model.WeatherModel


interface IDataRepository {
    suspend fun getWeatherForecast(): UseCaseResult<WeatherModel>
   }