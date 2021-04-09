package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.result.InfoPokemon
import com.example.pokemon.data.remote.result.ListPokemonResult
import com.example.pokemon.data.remote.result.PokemonResult
import com.example.pokemon.domain.model.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemote {

    fun fetchPokemons(): Flow<ListPokemonResult>

    fun fetchPokemonsInfo(listname: List<PokemonModel>): Flow<InfoPokemon>
}