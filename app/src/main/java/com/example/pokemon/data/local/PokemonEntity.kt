package com.example.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Pokemon")
class PokemonEntity(
    @PrimaryKey
    var name: String,

    @ColumnInfo(name = "id") var id: String,

    @ColumnInfo(name = "imageurl") var imageurl: String,

    @ColumnInfo(name = "height") var height: String,

    @ColumnInfo(name = "weight") var weight: String,

    @ColumnInfo(name = "category") var category: String,

    @ColumnInfo(name = "hp") var hp: Int,

    @ColumnInfo(name = "attack") var attack: Int,

    @ColumnInfo(name = "defense") var defense: Int,

    @ColumnInfo(name = "speed") var speed: Int,

    @ColumnInfo(name = "baseExp") var baseExp: String
)

