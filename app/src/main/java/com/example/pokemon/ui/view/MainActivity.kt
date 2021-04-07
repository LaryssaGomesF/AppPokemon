package com.example.pokemon.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.R
import com.example.pokemon.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
   private val mainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}