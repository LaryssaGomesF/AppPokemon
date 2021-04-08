package com.example.pokemon.data.remote.service

import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.result.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Path

interface ListPokemonService {

    @GET("pokemon")
    suspend fun list(): ListPokemonResult
}