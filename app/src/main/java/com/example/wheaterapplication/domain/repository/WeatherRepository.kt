package com.example.wheaterapplication.domain.repository

import com.example.wheaterapplication.domain.model.Status
import com.example.wheaterapplication.domain.model.Weather

interface WeatherRepository {
    suspend fun fetchWeatherFrom(location: String): Status<Weather>
}