package com.example.pokemon.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.pokemon.R
import com.example.pokemon.ui.viewmodel.SplashViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val splashViewModel by viewModel<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.checkConnection()
        observe()
    }

    private fun observe() {
        splashViewModel.successConnection.observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        })
    }
}