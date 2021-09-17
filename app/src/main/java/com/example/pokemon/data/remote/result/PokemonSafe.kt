package com.example.pokemon.data.remote.result

import com.example.pokemon.data.Raw

class PokemonSafe(
    val name: String,
    val id: String,
    val imageurl: String,
    val height: String,
    val category: String,
    val weight: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val baseExp: String
)