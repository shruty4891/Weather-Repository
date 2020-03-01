package com.exercise.weatherapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exercise.weatherapp.R
import com.exercise.weatherapp.databinding.ActivityWeatherItemBinding
import com.exercise.weatherapp.model.WeatherModel

class WeatherAdapter(private val weatherData: WeatherModel) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ViewHolder {
        val binding: ActivityWeatherItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(view.context),
            R.layout.activity_weather_item,
            view,
            false
        )
        return ViewHolder(binding);
    }

    override fun getItemCount(): Int {
        return weatherData.list!!.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mHumidity.text = "${weatherData.list!![position].main.humidity}"
        viewHolder.mPressure.text = "${weatherData.list!![position].main.pressure}"
        viewHolder.mTemp.text = "${weatherData.list!![position].main.temp}"

    }

    class ViewHolder(val binding: ActivityWeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val mHumidity = binding.tvHumidity
        val mPressure = binding.tvPressure
        val mTemp = binding.tvTemp
    }
}