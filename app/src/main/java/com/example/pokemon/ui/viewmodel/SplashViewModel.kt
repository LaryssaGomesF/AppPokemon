package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.repository.PokemonsRepository
import com.example.pokemon.data.repository.ResultAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(val repository: PokemonsRepository) : ViewModel() {

    val success: MutableLiveData<ListPokemonResult> = MutableLiveData()


    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchPokemons(object : ResultAPI<ListPokemonResult> {
                override fun onSuccess(value: ListPokemonResult) {
                    GlobalScope.launch {
                        delay(4000L)
                        success.postValue(value)
                    }
                }

            })
        }
    }
}