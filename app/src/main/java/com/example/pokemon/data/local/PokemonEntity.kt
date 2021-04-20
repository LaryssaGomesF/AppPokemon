package com.example.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "pokemons")
class PokemonEntity(
    @SerializedName("name")
    @PrimaryKey
    var name: String,

    @SerializedName("id")
    @ColumnInfo(name = "id") var id: Int,

    @SerializedName("height")
    @ColumnInfo(name = "height") var height: Int,

    @SerializedName("weight")
    @ColumnInfo(name = "weight") var weight: Int,

    @SerializedName("height")
    @ColumnInfo(name = "base_experience") var base_experience: Int
)

@Entity(tableName = "pokemonsname")
class PokemonNameEntity(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "url") var url: String
)

