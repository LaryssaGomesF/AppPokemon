package com.example.pokemon.data.repository

import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.remote.PokemonSafe
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonRoom(id: String): Flow<PokemonEntity>

    suspend fun fetchPokemon(): Flow<List<PokemonSafe>>
}