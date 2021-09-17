package com.example.pokemon.data.remote

import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon.json")
    fun getPokemonList(): List<PokemonRaw>
}