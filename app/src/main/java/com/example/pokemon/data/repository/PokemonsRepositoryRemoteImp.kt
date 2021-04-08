package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.PokemonResult
import com.example.pokemon.data.remote.service.ListPokemonService

class PokemonsRepositoryRemoteImp(val service: ListPokemonService): PokemonRepositoryRemote {
    override fun fetchPokemons(): PokemonResult {
        TODO("Not yet implemented")
    }
}