package com.example.wheaterapplication.presentation.di

import com.example.wheaterapplication.presentation.localweather.LocalWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

private val listKoinModules by lazy {
    loadKoinModules(
        listOf(
            viewModelModule
        )
    )
}

fun injectLocalWeatherKoin() = listKoinModules

private val viewModelModule: Module = module {
    viewModel {
        LocalWeatherViewModel()
    }
}