package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.domain.model.PokemonModel
import kotlin.Result

interface PokemonsRepository {

    suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>)

    suspend fun getPokemon(): List<PokemonModel>
}