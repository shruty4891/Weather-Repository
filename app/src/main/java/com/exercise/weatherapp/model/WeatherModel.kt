package com.exercise.weatherapp.model

import com.shruti.demoproject.model.City
import com.shruti.demoproject.model.ListModel

data class WeatherModel(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ListModel>?,
    val city: City
)