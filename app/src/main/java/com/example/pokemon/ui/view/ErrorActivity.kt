package com.example.pokemon.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.pokemon.R
import com.example.pokemon.databinding.ActivityErrorBinding
import com.example.pokemon.extensions.executeDelay

class ErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonTryAgain.setOnClickListener {
            tryAgain()
        }
    }

    fun tryAgain() {
        startActivity(Intent(this, SplashActivity::class.java))
        executeDelay(500L) { finish() }
    }
}