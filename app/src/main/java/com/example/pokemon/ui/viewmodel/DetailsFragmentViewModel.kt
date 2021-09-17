package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.local.asPokemonSafe
import com.example.pokemon.data.remote.result.PokemonSafe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragmentViewModel(val repositoryLocal: PokemonsDataBase) : ViewModel() {

    private val mPokemon: MutableLiveData<PokemonSafe> = MutableLiveData()
    var pokemon: LiveData<PokemonSafe> = mPokemon


    fun fetchPokemon(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = repositoryLocal.pokemonDao().getpokemon(id)
            mPokemon.postValue(pokemon.asPokemonSafe())
        }
    }
}