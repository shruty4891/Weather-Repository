package com.exercise.weatherapp.model

import com.shruti.demoproject.model.*

data class CurrentWeatherModel(
    val coord: Coord,
    val weather: List<Weather>?,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)