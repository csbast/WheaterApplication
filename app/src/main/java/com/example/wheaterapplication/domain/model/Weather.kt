package com.example.wheaterapplication.domain.model

data class Weather (
    val city: String,
    val weatherState: String,
    val temperature: Int,
    val description: String,
    val temperatureLow: Int,
    val temperatureHigh: Int,
)