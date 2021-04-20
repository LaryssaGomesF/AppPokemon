package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.repository.PokemonRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsFragmentViewModel(val repository: PokemonRepositoryImp): ViewModel() {

     val pokemon: MutableLiveData<PokemonEntity> = MutableLiveData()


     fun fetchPokemon(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchPokemonInfo(id)
                .catch{

                }.collect {
                    pokemon.postValue(it)
                }
        }
    }
}