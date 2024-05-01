package com.example.foodhelper.di.modules

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SourceModule {

    @Provides
    @Singleton
    fun providePrefs( context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE)
    }

    companion object {
        private const val PREFS_KEY = "prefs_key"
    }
}