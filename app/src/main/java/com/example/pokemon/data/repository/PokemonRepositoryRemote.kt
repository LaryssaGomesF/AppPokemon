package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.result.PokemonResult
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemote {

    fun fetchPokemons(): Flow<ListPokemonResult>
}