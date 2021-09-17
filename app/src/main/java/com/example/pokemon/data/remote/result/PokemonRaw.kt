package com.example.pokemon.data.remote.result

import com.example.pokemon.data.Raw
import com.google.gson.annotations.SerializedName

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
    @SerializedName("base_exp")
    val baseExp: String?
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
        baseExp = baseExp.orEmpty()
    )

}