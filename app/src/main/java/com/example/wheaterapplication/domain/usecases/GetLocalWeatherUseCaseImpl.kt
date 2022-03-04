package com.example.wheaterapplication.domain.usecases

import com.example.wheaterapplication.domain.model.Status
import com.example.wheaterapplication.domain.model.Weather
import com.example.wheaterapplication.domain.repository.WeatherRepository

class GetLocalWeatherUseCaseImpl(private val weatherRepository: WeatherRepository) :
    GetLocalWeatherUseCase {
    override suspend fun invoke(local: String): Status<Weather> {
        return weatherRepository.fetchWeatherFrom(local)
    }
}