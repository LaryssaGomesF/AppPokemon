package com.example.pokemon.data.remote

import com.example.pokemon.data.Raw

class PokemonRaw(
    val name: String?,
    val id: String?,
    val imageurl: String?,
    val height: String?,
    val category: String?,
    val weight: String?,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val base_exp: String?
) : Raw<PokemonSafe> {

    override fun asSafe() = PokemonSafe(
        name = name.orEmpty(),
        id = id.orEmpty(),
        imageurl = imageurl.orEmpty(),
        height = height.orEmpty(),
        category = category.orEmpty(),
        weight = weight.orEmpty(),
        hp = hp,
        attack = attack,
        defense = defense,
        speed = speed,
        base_exp = base_exp.orEmpty()
    )

}