package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.PokemonRaw
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemote {
    fun getPokemon(): Flow<List<PokemonRaw>>
}