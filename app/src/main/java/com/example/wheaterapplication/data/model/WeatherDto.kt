package com.example.wheaterapplication.data.model

import com.example.wheaterapplication.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName(value = "title")
    val city: String
) {
//    fun toWeater(): Weather = Weather(
//        city = city,
//        weatherState = "",
//        temperature = 0F,
//        description = "",
//        temperatureLow = 0.0,
//        temperatureHigh = 0.0
//    )
}
