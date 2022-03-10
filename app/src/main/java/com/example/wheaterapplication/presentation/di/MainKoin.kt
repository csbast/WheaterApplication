package com.example.wheaterapplication.presentation.di

import com.example.wheaterapplication.BuildConfig
import com.example.wheaterapplication.MyApplication
import com.example.wheaterapplication.presentation.builder.createOkHttpClient
import com.example.wheaterapplication.presentation.builder.createRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

fun setupKoin(myApplication: MyApplication) {
    startKoin{
        androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
        androidContext(myApplication)
        modules(emptyList())
    }
}


private val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(okHttpClient = get()) }
}