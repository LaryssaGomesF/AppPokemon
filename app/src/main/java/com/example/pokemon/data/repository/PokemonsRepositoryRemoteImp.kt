package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.InfoPokemon
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.service.ListPokemonService
import com.example.pokemon.data.remote.service.PokemonInfoService
import com.example.pokemon.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PokemonsRepositoryRemoteImp(val service: ListPokemonService, val serviceinfo: PokemonInfoService)  {

   fun fetchPokemons(): Flow<ListPokemonResult> {
        return flow {
            try {
                val result = service.list()
                emit(result)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

    fun fetchPokemonsInfo(listname: List<PokemonModel>): Flow<InfoPokemon> {
        return flow {
            try {
                for (i in listname){
                    val result = serviceinfo.fetchPokemonInfo(i.name)
                    emit(result)
                }

            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}