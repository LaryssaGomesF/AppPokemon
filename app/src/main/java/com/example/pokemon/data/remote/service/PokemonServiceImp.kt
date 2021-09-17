package com.example.pokemon.data.remote.service

import com.example.pokemon.data.remote.PokemonApi
import com.example.pokemon.data.remote.result.PokemonRaw
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonServiceImp(val pokemonApi: PokemonApi) : PokemonService {
    override fun getPokemonList(): Flow<List<PokemonRaw>> =
        flow {
            emit(
                pokemonApi.getPokemonList()
            )
        }

}