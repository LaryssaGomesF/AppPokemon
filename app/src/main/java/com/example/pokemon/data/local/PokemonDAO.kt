package com.example.pokemon.data.local

import androidx.room.*

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

@Database(entities = [PokemonEntity::class, PokemonNameEntity::class], version = 1)
abstract class PokemonsDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDAO
}