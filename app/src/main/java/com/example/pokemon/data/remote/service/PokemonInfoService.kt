package com.example.pokemon.data.remote.service

import com.example.pokemon.data.remote.result.InfoPokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInfoService {

    @GET("pokemon/{pokemon}")
    suspend fun fetchPokemonInfo(@Path("pokemon") name:String): InfoPokemon
}