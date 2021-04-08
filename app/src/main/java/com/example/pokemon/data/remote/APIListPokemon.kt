package com.example.pokemon.data.remote

import com.example.pokemon.data.remote.service.ListPokemonService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIListPokemon {

    companion object {
        private val baseurl = "https://pokeapi.co/api/v2/"
        val httpClient = OkHttpClient.Builder().build()

        var apiService = connectionRetrofit().create(ListPokemonService::class.java)

        private fun connectionRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()

        }
    }
}