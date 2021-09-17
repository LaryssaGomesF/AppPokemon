package com.example.pokemon.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokemon.domain.model.PokemonModel

@Dao
interface PokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(entities: PokemonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addname(entities: List<PokemonNameEntity>)

    @Query("SELECT * FROM pokemons")
    fun getAll(): LiveData<List<PokemonEntity>>

    @Query("SELECT * FROM pokemons WHERE id in (:id)")
    fun getpokemon(id: String): PokemonEntity

    @Query("SELECT * FROM pokemonsname")
    suspend fun get(): List<PokemonNameEntity>

}

@Database(entities = [PokemonEntity::class, PokemonNameEntity::class], version = 2)
abstract class PokemonsDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDAO
}

fun List<PokemonNameEntity>.asDomainModel(): List<PokemonModel> {
    return map {
        PokemonModel(
            name = it.name,
            url = it.url
        )
    }
}

fun List<PokemonEntity>.asDomainModelList(): List<PokemonModel> {
    return map {
        PokemonModel(
            name = it.name,
            id = it.id,
            weight = it.weight,
            height = it.height,
            base_experience = it.base_experience,
            url = ""
        )
    }
}

fun PokemonEntity.asDomainModel(): PokemonModel {
    return PokemonModel(
            name = name,
            id = id,
            weight = weight,
            height = height,
            base_experience = base_experience,
            url = ""
        )

}