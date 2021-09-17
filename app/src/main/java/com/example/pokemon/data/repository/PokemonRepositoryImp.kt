package com.example.pokemon.data.repository


import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.remote.PokemonSafe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class PokemonRepositoryImp(
    val repositoryPokemonRemote: PokemonRepositoryRemoteImp,
    val PokemonRoom: PokemonsDataBase
): PokemonRepository {


    override suspend fun fetchPokemon(): Flow<List<PokemonSafe>> {
        return flow {
            try {

            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }

    }


    override suspend fun getPokemonRoom(id: String): Flow<PokemonEntity> {
        return flow {
            try {

            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

}