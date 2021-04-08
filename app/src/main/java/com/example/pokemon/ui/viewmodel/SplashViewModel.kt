package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.repository.PokemonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(val repository: PokemonsRepository) : ViewModel() {

    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchPokemons()
        }
    }
}