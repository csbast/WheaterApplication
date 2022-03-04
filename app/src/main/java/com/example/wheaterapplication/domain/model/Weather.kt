package com.example.wheaterapplication.domain.model

data class Weather (
    val city: String,
    val weatherState: String,
    val temperature: Float,
    val description: String,
    val latitude: Double,
    val longitude: Double,
)