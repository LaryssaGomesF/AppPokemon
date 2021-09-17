package com.example.pokemon.data.remote.service

import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.remote.PokemonRaw
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{pokemon}")
    suspend fun getPokemonList(): List<PokemonRaw>
}