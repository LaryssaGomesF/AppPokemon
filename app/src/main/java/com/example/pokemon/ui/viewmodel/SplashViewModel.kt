package com.example.pokemon.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.data.remote.repository.PokemonRepositoryRemoteImp

class SplashViewModel(var repositoryPokemon: PokemonRepositoryRemoteImp) : ViewModel() {

    private var mSuccessConnection: MutableLiveData<Boolean> = MutableLiveData()
    var successConnection: LiveData<Boolean> = mSuccessConnection

    fun checkConnection() {

        mSuccessConnection.value = true

    }

    fun checkDataBase(){

    }
}