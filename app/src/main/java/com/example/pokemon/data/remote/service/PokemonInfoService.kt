package com.example.pokemon.data.remote.service

import com.example.pokemon.data.local.PokemonEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInfoService {

    @GET("pokemon/{pokemon}")
    suspend fun fetchPokemonInfo(@Path("pokemon") name:String): PokemonEntity
}