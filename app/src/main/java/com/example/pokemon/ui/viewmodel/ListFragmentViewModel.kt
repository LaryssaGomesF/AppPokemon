package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.local.asDomainModelList
import com.example.pokemon.data.remote.result.InfoPokemon
import com.example.pokemon.data.repository.PokemonsRepository
import com.example.pokemon.data.repository.ResultAPI
import com.example.pokemon.domain.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragmentViewModel(val repository: PokemonsRepository, dataBase: PokemonsDataBase) : ViewModel() {

    var list: LiveData<List<PokemonEntity>> = dataBase.pokemonDao().getAll()

    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemon()
        }
    }


}