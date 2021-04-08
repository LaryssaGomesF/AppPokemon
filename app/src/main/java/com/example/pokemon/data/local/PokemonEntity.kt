package com.example.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemons")
class PokemonEntity(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "height") var height: String,
    @ColumnInfo(name = "weight") var weight: String,
    @ColumnInfo(name = "base_experience") var base_experience: String
)

@Entity(tableName = "pokemonsname")
class PokemonNameEntity(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "url") var url: String
)

