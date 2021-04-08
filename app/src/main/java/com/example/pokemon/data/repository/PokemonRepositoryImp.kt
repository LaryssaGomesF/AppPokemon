package com.example.pokemon.data.repository

import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.remote.result.PokemonResult

class PokemonRepositoryImp(
    val repositoryRemote: PokemonRepositoryRemote,
    val database: PokemonsDataBase
) :PokemonsRepository {
    override fun fetchPokemons(): List<PokemonResult> {
        TODO("Not yet implemented")
    }
}