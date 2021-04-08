package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.PokemonResult

interface PokemonsRepository {

    fun fetchPokemons(): List<PokemonResult>
}