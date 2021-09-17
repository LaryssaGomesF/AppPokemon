package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.repository.PokemonRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragmentViewModel(val pokemonRepository: PokemonRepositoryImp, pokemoRoom: PokemonsDataBase) : ViewModel() {

    var list: LiveData<List<PokemonEntity>> = pokemoRoom.pokemonDao().getAll()

    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
           // repository.getPokemon()
        }
    }


}