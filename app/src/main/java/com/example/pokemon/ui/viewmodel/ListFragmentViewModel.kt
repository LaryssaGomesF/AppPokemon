package com.example.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.remote.PokemonRaw
import com.example.pokemon.data.remote.PokemonSafe
import com.example.pokemon.data.repository.PokemonRepositoryRemoteImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListFragmentViewModel(
    var repositoryPokemon: PokemonRepositoryRemoteImp
) : ViewModel() {

    private var mSuccessListPokemon: MutableLiveData<List<PokemonSafe>> = MutableLiveData()
    var successListPokemon: LiveData<List<PokemonSafe>> = mSuccessListPokemon

    private var mErrorListPokemon: MutableLiveData<Boolean> = MutableLiveData()
    var errorListPokemon: LiveData<Boolean> = mErrorListPokemon

    fun fetchPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryPokemon.getPokemon()
                .catch {
                    it.message
                }.collect {
                    mSuccessListPokemon.postValue(it)
                }
        }
    }


}