package com.example.pokemon.data.remote.result

import com.google.gson.annotations.SerializedName

class PokemonResult {
    @SerializedName("id")
    var id: String = ""

    @SerializedName("name")
    var name: String = ""

    @SerializedName("height")
    var height: String = ""

    @SerializedName("weight")
    var weight: String = ""

    @SerializedName("base_experience")
    var base_experience: String = ""

}