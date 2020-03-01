package com.exercise.weatherapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exercise.weatherapp.R
import com.exercise.weatherapp.databinding.ActivityWeatherBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        binding.lifecycleOwner=this
        binding.viewModel=weatherViewModel

        initObserver()
        setupRecyclerView()
        //API Calling
        weatherViewModel.getWeatherInfo()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    private fun initObserver()
    {
        weatherViewModel.list.observe(this, Observer {
            it?.let {
                val weatherAdapter = WeatherAdapter(it)
                binding.recyclerView.adapter = weatherAdapter
            }
        })
    }
}
