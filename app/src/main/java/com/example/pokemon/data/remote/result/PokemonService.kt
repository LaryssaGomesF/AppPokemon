package com.example.pokemon.data.remote.result

import com.example.pokemon.data.remote.PokemonRaw
import kotlinx.coroutines.flow.Flow

interface PokemonService {

    fun getPokemonList(): Flow<List<PokemonRaw>>
}