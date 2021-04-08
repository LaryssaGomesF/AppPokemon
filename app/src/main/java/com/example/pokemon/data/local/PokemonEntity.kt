package com.example.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemons")
class PokemonEntity(
    @PrimaryKey
    var id: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "height") var height: String,
    @ColumnInfo(name = "weight") var weight: String,
    @ColumnInfo(name = "base_experience") var base_experience: String
)
