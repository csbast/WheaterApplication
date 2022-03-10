package com.example.wheaterapplication.presentation.localweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheaterapplication.R
import com.example.wheaterapplication.domain.model.Weather
import com.example.wheaterapplication.presentation.model.WeatherUiState

class LocalWeatherViewModel : ViewModel() {

    private val _weatherLiveData: MutableLiveData<WeatherUiState> = MutableLiveData()
    val weatherLiveData: LiveData<WeatherUiState> get() = _weatherLiveData

    fun loadWeatherInfo() {
        val weather = WeatherUiState(
            city = "Rio das Ostras",
            temperature = 0,
            description = "Light Rain",
            iconDrawable = R.drawable.cloudy,
            lowTemperature = "5",
            highTemperature = "15"
        )
        _weatherLiveData.postValue(weather)
    }
}