package com.example.pokemon.data.local

import androidx.room.*
import com.example.pokemon.domain.model.PokemonModel

@Dao
interface PokemonDAO {

    @Insert
    suspend fun add(entities: PokemonEntity)

    @Insert
    suspend fun addname(entities: List<PokemonNameEntity>)

    @Query("SELECT * FROM pokemons")
    suspend fun getAll(): List<PokemonEntity>

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