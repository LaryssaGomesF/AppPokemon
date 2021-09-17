package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.PokemonRaw
import com.example.pokemon.data.remote.service.PokemonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PokemonRepositoryRemoteImp(val PokemonService: PokemonService): PokemonRepositoryRemote  {

   override fun getPokemon(): Flow<List<PokemonRaw>> {
        return flow {
            try {

            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

}