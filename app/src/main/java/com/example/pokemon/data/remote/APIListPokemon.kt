package com.example.pokemon.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIListPokemon {

    companion object {
        private val baseurl = "https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/"
        val httpClient = OkHttpClient.Builder().build()

        var apiService = connectionRetrofit().create(PokemonApi::class.java)

        private fun connectionRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}