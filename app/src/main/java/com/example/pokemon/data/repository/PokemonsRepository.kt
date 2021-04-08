package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.ListPokemonResult
import kotlin.Result

interface PokemonsRepository {

    suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>)

    suspend fun getPokemon()
}