package com.example.pokemon.di

import com.example.pokemon.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {
    viewModel {
        MainViewModel()
    }

}