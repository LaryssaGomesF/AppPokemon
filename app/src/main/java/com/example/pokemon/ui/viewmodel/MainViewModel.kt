package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.repository.PokemonsRepository
import com.example.pokemon.domain.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: PokemonsRepository) : ViewModel() {

    val success: MutableLiveData<List<PokemonModel>> = MutableLiveData()

    fun fetchPokemons() {
        viewModelScope.launch (Dispatchers.IO){
           val result = repository.getPokemon()
            success.postValue(result)
        }

    }

   fun fetchPokemonInfo(){

    }
}