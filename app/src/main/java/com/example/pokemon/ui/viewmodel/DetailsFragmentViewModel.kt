package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.remote.repository.PokemonRepositoryRemote
import com.example.pokemon.data.remote.repository.PokemonRepositoryRemoteImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragmentViewModel(val repositoryPokemon: PokemonRepositoryRemoteImp): ViewModel() {

     val pokemon: MutableLiveData<PokemonEntity> = MutableLiveData()


     fun fetchPokemon(id: String){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}