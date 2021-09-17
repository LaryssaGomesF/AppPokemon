package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.PokemonRaw
import com.example.pokemon.data.remote.PokemonSafe
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemote {
    suspend fun getPokemon(): Flow<List<PokemonSafe>>
}