package com.exercise.weatherapp.ui.mainlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exercise.weatherapp.R
import com.exercise.weatherapp.databinding.FragmentTodoListBinding
import com.shruti.demoproject.view.WeatherAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherFragment : Fragment() {
    lateinit var binding: FragmentTodoListBinding
    private val todoListModel: MainActivityViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_list, container, false)
        binding.lifecycleOwner=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoListModel.getWeatherForcast()

        binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.tvReload.setOnClickListener {
            binding.shimmerViewContainer.startShimmer()
            todoListModel.getWeatherForcast()
        }
    }

    override fun onStart() {
        super.onStart()
        todoListModel.list.observe(this, Observer {
            it?.let {
                val todoListAdapter = WeatherAdapter(it)
                binding.recyclerView.adapter = todoListAdapter
            }
        })

        todoListModel.isShimmerGone.observe(this, Observer {
            stopShimmer()
        })
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
     }

    override fun onPause() {
        super.onPause()
        binding.shimmerViewContainer.stopShimmer()
    }

    private fun stopShimmer() {
        binding.shimmerViewContainer.stopShimmer();
        binding.shimmerViewContainer.visibility = View.GONE;
    }
}
