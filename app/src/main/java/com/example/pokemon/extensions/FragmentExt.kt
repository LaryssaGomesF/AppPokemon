package com.example.pokemon.extensions

import android.os.Handler
import androidx.fragment.app.Fragment

fun Fragment.executeDelay(delay: Long = 200, callback: () -> Unit) {
    Handler().postDelayed({
        callback()
    }, delay)
}