package com.example.pokemon.domain.model

data class PokemonModel(
    var name: String,
    val id: String = "",
    val weight: String = "",
    val height: String = "",
    val base_experience: String = "",
    val url: String
)