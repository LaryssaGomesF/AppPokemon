package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.InfoPokemon
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.domain.model.PokemonModel

interface PokemonsRepository {

    suspend fun fetchPokemons(listener: ResultAPI<ListPokemonResult>)

    suspend fun getPokemon(listener: ResultAPI<InfoPokemon>)
}