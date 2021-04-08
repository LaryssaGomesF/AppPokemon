package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.service.ListPokemonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PokemonsRepositoryRemoteImp(val service: ListPokemonService) : PokemonRepositoryRemote {

    override fun fetchPokemons(): Flow<ListPokemonResult> {
        return flow {
            try {
                val result = service.list()
                emit(result)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}