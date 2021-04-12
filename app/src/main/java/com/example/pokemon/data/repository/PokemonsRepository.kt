package com.example.pokemon.data.repository

import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.remote.result.InfoPokemon
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {

    suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>)

    suspend fun getPokemon()

    suspend fun fetchPokemonInfo(id: String): Flow<PokemonEntity>
}