package com.example.foodhelper.search_page

import java.util.*

class Debouncer(private val delay: Long) {
    private var timer: Timer? = null

    fun debounce(action: () -> Unit) {
        timer?.cancel()
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                action()
            }
        }, delay)
    }
}