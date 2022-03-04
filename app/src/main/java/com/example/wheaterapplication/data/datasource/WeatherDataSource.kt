package com.example.wheaterapplication.data.datasource

import com.example.wheaterapplication.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface  WeatherDataSource {
    @GET("location/{locationId}")
    suspend fun fetcWeatherInfo(@Path("locationId")locationId: String): WeatherDto
}