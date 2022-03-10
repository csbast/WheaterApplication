package com.example.wheaterapplication.presentation.model

import android.content.Intent
import androidx.annotation.DrawableRes

data class WeatherUiState(
    val city: String,
    @DrawableRes val iconDrawable: Int,
    val temperature: Int,
    val description: String,
    val lowTemperature: String,
    val highTemperature: String
    )
