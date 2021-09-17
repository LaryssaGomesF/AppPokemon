package com.example.pokemon.extensions

import android.app.Activity
import android.os.Handler
import androidx.fragment.app.Fragment

fun Activity.executeDelay(delay: Long = 200, callback: () -> Unit) {
    Handler().postDelayed({
        callback()
    }, delay)
}