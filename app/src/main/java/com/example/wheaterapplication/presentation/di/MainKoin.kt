package com.example.wheaterapplication.presentation.di

import android.app.Application
import com.example.wheaterapplication.MyApplication
import com.example.wheaterapplication.presentation.builder.createOkHttpClient
import com.example.wheaterapplication.presentation.builder.createRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun startKoin(application: Application) {

    fun setupKoin(myApplication: MyApplication) {
        startKoin {
            androidLogger()
            androidContext(myApplication)
            modules(

            )
        }
    }
}

private val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(okHttpClient = get()) }
}