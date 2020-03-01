package com.shruti.demoproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(
    val temp: Double,
    @SerializedName("feels_like")
    @Expose
    val feelsLike: Double,
    @SerializedName("temp_min")
    @Expose
    val tempMin: Double,
    @SerializedName("temp_max")
    @Expose
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val grndLevel: Int,
    val humidity: Int,
    val tempKf: Int
)