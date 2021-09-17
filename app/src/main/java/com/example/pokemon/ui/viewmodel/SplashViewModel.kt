package com.example.pokemon.ui.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.AppConnection
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.remote.repository.PokemonRepositoryImp

class SplashViewModel(var repositoryPokemonLocal: PokemonsDataBase) : ViewModel() {

    private var mSuccessConnection: MutableLiveData<Boolean> = MutableLiveData()
    var successConnection: LiveData<Boolean> = mSuccessConnection

    private var mErrorConnection: MutableLiveData<Boolean> = MutableLiveData()
    var errorConnection: LiveData<Boolean> = mErrorConnection

    private var mSuccessDatabase: MutableLiveData<Boolean> = MutableLiveData()
    var successDatabase: LiveData<Boolean> = mSuccessDatabase

    private var mErrorDatabase: MutableLiveData<Boolean> = MutableLiveData()
    var errorDatabase: LiveData<Boolean> = mErrorDatabase

    fun checkConnection(context: Context) {

        if (AppConnection.isOnline(context)) {
            mSuccessConnection.postValue(true)
        } else {
            mErrorConnection.postValue(false)
        }

    }

    fun checkDataBase() {
        val list = repositoryPokemonLocal.pokemonDao().getAll()
        if (list.value?.size == 0) {
            mErrorDatabase.postValue(false)
        } else {
            mSuccessDatabase.postValue(true)
        }
    }
}