package com.exercise.weatherapp.data.network

import com.exercise.weatherapp.model.CurrentWeatherModel
import com.exercise.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("/data/2.5/forecast?zip=122001,in&appid=f4b98a08513742f455b15bc7e6f4016e")
    suspend fun getWeatherForecast(): Response<WeatherModel>

    @GET("/data/2.5/weather?q=122001,in&APPID=f4b98a08513742f455b15bc7e6f4016e")
    suspend fun getCurrentWeather(): Response<CurrentWeatherModel>

}