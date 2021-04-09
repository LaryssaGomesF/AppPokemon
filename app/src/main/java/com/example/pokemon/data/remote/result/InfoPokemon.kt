package com.example.pokemon.data.remote.result

import com.example.pokemon.data.local.PokemonEntity
import com.google.gson.annotations.SerializedName

class InfoPokemon {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("height")
    var height: Int = 0

    @SerializedName("weight")
    var weight: Int = 0

    @SerializedName("base_experience")
    var base_experience: Int = 0
}

fun InfoPokemon.asDatabaseModel(): PokemonEntity {
    return PokemonEntity(
            id = id,
            name = name,
            height = height,
            weight = weight,
            base_experience = base_experience
        )

}