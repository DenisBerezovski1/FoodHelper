package com.example.data.source

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    fun getUserToken(): String = prefs.getString(TOKEN_KEY, EMPTY_STRING).orEmpty()

    fun setUserToken(token: String) = prefs.edit {
        putString(TOKEN_KEY, token)
    }

    fun setBreakfastUpdate(update: Boolean) = prefs.edit {
        putBoolean(BREAKFAST_KEY, update)
    }

    fun getBreakfastUpdate(): Boolean = prefs.getBoolean(BREAKFAST_KEY, false)

    fun setBrunchUpdate(update: Boolean) = prefs.edit {
        putBoolean(BRUNCH_KEY, update)
    }

    fun getBrunchUpdate(): Boolean = prefs.getBoolean(BRUNCH_KEY, false)

    fun setLunchUpdate(update: Boolean) = prefs.edit {
        putBoolean(LUNCH_KEY, update)
    }

    fun getLunchUpdate(): Boolean = prefs.getBoolean(LUNCH_KEY, false)

    fun setDinnerUpdate(update: Boolean) = prefs.edit {
        putBoolean(DINNER_KEY, update)
    }

    fun getDinnerUpdate(): Boolean = prefs.getBoolean(DINNER_KEY, false)

    companion object {
        private const val EMPTY_STRING = ""
        private const val TOKEN_KEY = "TOKEN_KEY"
        private const val BREAKFAST_KEY = "BREAKFAST_KEY"
        private const val BRUNCH_KEY = "BRUNCH_KEY"
        private const val LUNCH_KEY = "LUNCH_KEY"
        private const val DINNER_KEY = "DINNER_KEY"
    }
}