package com.example.foodhelper

import android.app.Application
import com.example.foodhelper.di.AppComponent
import com.example.foodhelper.di.DaggerAppComponent

class FoodApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}