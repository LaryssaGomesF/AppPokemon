package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.repository.PokemonRepositoryRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragmentViewModel(val repositoryPokemon: PokemonRepositoryRemote): ViewModel() {

     val pokemon: MutableLiveData<PokemonEntity> = MutableLiveData()


     fun fetchPokemon(id: String){
        viewModelScope.launch(Dispatchers.IO) {
//            repository.fetchPokemonInfo(id)
//                .catch{
//
//                }.collect {
//                    pokemon.postValue(it)
//                }
        }
    }
}