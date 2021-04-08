package com.example.pokemon.data.remote.result

import com.google.gson.annotations.SerializedName

class ListPokemonResult {
    @SerializedName("results")
    var Pokemons: ArrayList<PokemonResult>? = null
}


class PokemonResult {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("url")
    var url: String = ""
}