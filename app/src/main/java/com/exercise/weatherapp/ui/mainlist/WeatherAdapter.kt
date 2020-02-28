package com.shruti.demoproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exercise.weatherapp.R
import com.exercise.weatherapp.model.WeatherModel

class WeatherAdapter(private val weatherData: WeatherModel) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ViewHolder {
        val v =
            LayoutInflater.from(view.context).inflate(R.layout.adapter_product_list, view, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return weatherData.list!!.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mlocation?.text = "" + weatherData.city.name+"," + weatherData.city.country
        viewHolder.mWindSpeed?.text = "" + weatherData.list!!.get(position).wind.speed
        viewHolder.mHumidity?.text = "" + weatherData.list!!.get(position).main.humidity
        viewHolder.mSealevel?.text = "" + weatherData.list!!.get(position).main.seaLevel
        viewHolder.mTemp?.text = "" + weatherData.list!!.get(position).main.temp

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mlocation = itemView.findViewById<TextView>(R.id.tv_location)
        val mWindSpeed = itemView.findViewById<TextView>(R.id.tv_Speed)
        val mHumidity = itemView.findViewById<TextView>(R.id.tv_humdity)
        val mSealevel = itemView.findViewById<TextView>(R.id.tv_sea_level)
        val mTemp = itemView.findViewById<TextView>(R.id.tv_temp)

    }
}