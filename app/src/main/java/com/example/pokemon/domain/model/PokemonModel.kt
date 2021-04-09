package com.example.pokemon.domain.model

data class PokemonModel(
    var name: String,
    val id: Int = 0,
    val weight: Int = 0,
    val height: Int = 0,
    val base_experience: Int = 0,
    val url: String
)