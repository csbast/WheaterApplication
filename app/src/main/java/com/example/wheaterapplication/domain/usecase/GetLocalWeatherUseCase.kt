package com.example.wheaterapplication.domain.usecase

import com.example.wheaterapplication.domain.model.Status
import com.example.wheaterapplication.domain.model.Weather

interface GetLocalWeatherUseCase {
    suspend fun invoke(local: String): Status<Weather>
}