package com.example.pokemon.data.local

import androidx.room.*

@Dao
interface PokemonDAO {

    @Insert
    suspend fun add(entities: PokemonEntity)

    @Query("SELECT * FROM pokemons")
    suspend fun getAll(): List<PokemonEntity>

}

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonsDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDAO
}