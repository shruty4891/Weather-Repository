package com.exercise.weatherapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("intText")
fun imageState(textview: TextView, value: Int) {
    textview.text = "$value"
}

@BindingAdapter("doubleText")
fun doubleText(textview: TextView, value: Double) {
    textview.text = "$value"
}

@BindingAdapter("date")
fun dateValue(textview: TextView, value: Long) {
    DateUtils.getDateAsString(value)
    textview.text = DateUtils.getDateAsString(value)
}