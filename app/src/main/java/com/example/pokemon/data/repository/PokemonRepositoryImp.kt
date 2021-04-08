package com.example.pokemon.data.repository


import com.example.pokemon.data.remote.result.ListPokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class PokemonRepositoryImp(
    val repositoryRemote: PokemonsRepositoryRemoteImp
) : PokemonsRepository {


    override suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>) {
        GlobalScope.launch(Dispatchers.IO) {
            repositoryRemote.fetchPokemons()
                .catch { e ->

                }.collect {
                    listener.onSuccess(it)

                }
        }

    }
}