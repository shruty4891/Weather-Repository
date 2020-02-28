package com.shruti.demoproject.model

data class ListModel(
    val dt: Int,
    val main: Main,
    val weather: List<Weather>?,
    val clouds: Clouds,
    val wind: Wind,
    val sys: Sys,
    val dtTxt: String,
    val snow: Snow,
    val rain: Rain
)