package com.exercise.weatherapp.data.network

import com.exercise.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi{
    @GET("/data/2.5/forecast?zip=127021,in&appid=f4b98a08513742f455b15bc7e6f4016e")
    suspend fun getWeatherForecast(): Response<WeatherModel>

}