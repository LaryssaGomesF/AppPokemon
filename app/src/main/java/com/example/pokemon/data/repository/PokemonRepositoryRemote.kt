package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.PokemonSafe
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemote {
    suspend fun getPokemon(): Flow<List<PokemonSafe>>
}