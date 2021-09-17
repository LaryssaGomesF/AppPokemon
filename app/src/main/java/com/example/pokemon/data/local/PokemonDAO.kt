package com.example.pokemon.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokemon.data.remote.result.PokemonSafe

@Dao
interface PokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(entities: List<PokemonEntity>)

    @Query("SELECT * FROM Pokemon")
    fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM Pokemon WHERE id in (:id)")
    fun getpokemon(id: String): PokemonEntity

}

@Database(entities = [PokemonEntity::class], version = 2)
abstract class PokemonsDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDAO
}


fun List<PokemonEntity>.asListPokemonSafe(): List<PokemonSafe> {
    return map {
        PokemonSafe(
            name = it.name,
            id = it.id,
            weight = it.weight,
            height = it.height,
            imageurl = it.imageurl,
            baseExp = it.baseExp,
            category = it.category,
            hp = it.hp,
            attack = it.attack,
            defense = it.defense,
            speed = it.speed
        )
    }
}

fun PokemonEntity.asPokemonSafe(): PokemonSafe {
    return PokemonSafe(
        name = name,
        id = id,
        weight = weight,
        height = height,
        imageurl = imageurl,
        baseExp = baseExp,
        category = category,
        hp = hp,
        attack = attack,
        defense = defense,
        speed = speed
    )

}

fun List<PokemonSafe>.asListPokemonEntity(): List<PokemonEntity> {
    return map {
        PokemonEntity(
            name = it.name,
            id = it.id,
            weight = it.weight,
            height = it.height,
            imageurl = it.imageurl,
            baseExp = it.baseExp,
            category = it.category,
            hp = it.hp,
            attack = it.attack,
            defense = it.defense,
            speed = it.speed
        )
    }
}

