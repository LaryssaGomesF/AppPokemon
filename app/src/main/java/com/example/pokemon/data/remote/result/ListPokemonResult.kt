package com.example.pokemon.data.remote.result

import com.example.pokemon.data.local.PokemonNameEntity
import com.google.gson.annotations.SerializedName

class ListPokemonResult {
    @SerializedName("results")
    var Pokemons: List<PokemonResult> = listOf()
}


class PokemonResult {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("url")
    var url: String = ""
}


data class NameContainer(val container: List<PokemonResult>)


fun NameContainer.asDatabaseModel(): List<PokemonNameEntity> {
    return container.map {
        PokemonNameEntity(
            name = it.name,
            url = it.url
        )
    }
}