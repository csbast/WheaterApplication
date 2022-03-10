package com.example.wheaterapplication.presentation.localweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.wheaterapplication.R
import com.example.wheaterapplication.databinding.FragmentLocalWeatherBinding
import com.example.wheaterapplication.presentation.di.injectLocalWeatherKoin
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocalWeatherFragment : Fragment() {

    private var _binding: FragmentLocalWeatherBinding? = null
    private val binding: FragmentLocalWeatherBinding get() = _binding!!
    private val viewModel: LocalWeatherViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        injectLocalWeatherKoin()
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_local_weather, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadWeatherInfo()
        setupObservers()
    }

    private fun setupObservers() {
        setupWeatherLiveData()
    }

    private fun setupWeatherLiveData() {
        viewModel.weatherLiveData.observe(viewLifecycleOwner) { weather ->
            binding.locationIdTv.text = weather.city
            binding.weatherIcon.background = resources.getDrawable(weather.iconDrawable)
            binding.highTemperatureTv.text = weather.highTemperature
            binding.lowTemperatureTv.text = weather.lowTemperature
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}