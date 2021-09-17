package com.example.pokemon.data.remote.service

import com.example.pokemon.data.remote.result.PokemonRaw
import kotlinx.coroutines.flow.Flow

interface PokemonService {

    fun getPokemonList(): Flow<List<PokemonRaw>>
}