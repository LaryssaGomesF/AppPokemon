package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.repository.PokemonRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(val repository: PokemonRepositoryImp) : ViewModel() {

    val success: MutableLiveData<ListPokemonResult> = MutableLiveData()


    fun fetchPokemon() {

        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchPokemon().catch
        }


    }
}