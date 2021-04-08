package com.example.pokemon.data.repository

interface PokemonsRepository {

    suspend fun fetchPokemons()
}