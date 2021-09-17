package com.example.pokemon.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.AppConnection
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.local.asListPokemonEntity
import com.example.pokemon.data.local.asListPokemonSafe
import com.example.pokemon.data.remote.repository.PokemonRepositoryImp
import com.example.pokemon.data.remote.result.PokemonSafe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListFragmentViewModel(
    var repositoryPokemon: PokemonRepositoryImp,
    var repositoryLocal: PokemonsDataBase
) : ViewModel() {

    private var mSuccessListPokemon: MutableLiveData<List<PokemonSafe>> = MutableLiveData()
    var successListPokemon: LiveData<List<PokemonSafe>> = mSuccessListPokemon

    private var mErrorListPokemon: MutableLiveData<Boolean> = MutableLiveData()
    var errorListPokemon: LiveData<Boolean> = mErrorListPokemon

    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryPokemon.getPokemon()
                .catch {
                    mErrorListPokemon.postValue(false)
                }.collect {
                    mSuccessListPokemon.postValue(it)
                    repositoryLocal.pokemonDao().add(it.asListPokemonEntity())
                }
        }
    }

    fun checkConnection(context: Context) {

        if (AppConnection.isOnline(context)) {
            fetchPokemons()
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val list = repositoryLocal.pokemonDao().getAll().asListPokemonSafe()
                mSuccessListPokemon.postValue(list)
            }
        }

    }

}