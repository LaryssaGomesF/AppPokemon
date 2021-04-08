package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.PokemonResult

interface PokemonRepositoryRemote {

    fun fetchPokemons(): PokemonResult
}