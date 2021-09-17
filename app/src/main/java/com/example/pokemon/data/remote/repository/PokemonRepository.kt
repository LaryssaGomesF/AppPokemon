package com.example.pokemon.data.remote.repository

import com.example.pokemon.data.remote.result.PokemonSafe
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemon(): Flow<List<PokemonSafe>>
}