package com.example.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemons")
class PokemonEntity(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "height") var height: Int,
    @ColumnInfo(name = "weight") var weight: Int,
    @ColumnInfo(name = "base_experience") var base_experience: Int
)

@Entity(tableName = "pokemonsname")
class PokemonNameEntity(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "url") var url: String
)

