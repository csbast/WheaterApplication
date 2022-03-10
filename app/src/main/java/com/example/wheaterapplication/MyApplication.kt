package com.example.wheaterapplication

import android.app.Application
import com.example.wheaterapplication.presentation.di.setupKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin(this)
    }
}