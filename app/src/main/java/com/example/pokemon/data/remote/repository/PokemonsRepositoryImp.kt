package com.example.pokemon.data.remote.repository

import com.example.pokemon.data.remote.result.PokemonSafe
import com.example.pokemon.data.remote.service.PokemonServiceImp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class PokemonRepositoryImp(val pokemonService: PokemonServiceImp) : PokemonRepository {

    override suspend fun getPokemon(): Flow<List<PokemonSafe>> =
        pokemonService.getPokemonList().map { list ->
            list.map { it.asSafe() }
        }

}