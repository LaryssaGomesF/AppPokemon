package com.example.pokemon.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pokemon.R


class MainActivity : AppCompatActivity() {
    lateinit var navCtrlr: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navCtrlr = Navigation.findNavController(this, R.id.navigation)
    }


}