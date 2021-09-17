package com.example.pokemon.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.repository.PokemonRepositoryRemote
import com.example.pokemon.data.repository.PokemonRepositoryRemoteImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SplashViewModel(var repositoryPokemon: PokemonRepositoryRemoteImp) : ViewModel() {

    private var mSuccess: MutableLiveData<Boolean> = MutableLiveData()
    var success: LiveData<Boolean> = mSuccess
    fun fetchPokemon() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repositoryPokemon.getPokemon()
//                .catch {
//
//                }.collect {
//
//                }
//        }
        mSuccess.value = true

    }
}