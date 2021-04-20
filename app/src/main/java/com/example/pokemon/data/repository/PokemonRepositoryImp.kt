package com.example.pokemon.data.repository


import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.local.asDomainModel
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.result.NameContainer
import com.example.pokemon.data.remote.result.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class PokemonRepositoryImp(
    val repositoryRemote: PokemonsRepositoryRemoteImp,
    val database: PokemonsDataBase
) {


    suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>) {
        GlobalScope.launch(Dispatchers.IO) {
            repositoryRemote.fetchPokemons()
                .catch { e ->

                }.collect {
                    listener.onSuccess(it)
                    val container = NameContainer(it.Pokemons)
                    database.pokemonDao().addname(container.asDatabaseModel())
                }
        }

    }

    suspend fun getPokemon() {
        val namelist = database.pokemonDao().get().asDomainModel()
        GlobalScope.launch(Dispatchers.IO) {
            repositoryRemote.fetchPokemonsInfo(namelist)
                .catch { e ->

                }.collect {
                    database.pokemonDao().add(it)
                }
        }
    }

    suspend fun fetchPokemonInfo(id: String): Flow<PokemonEntity> {
        return flow {
            try {
                val pokemon = database.pokemonDao().getpokemon(id)
                emit(pokemon)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

}