package com.example.pokemon.di

import androidx.room.Room
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.data.remote.APIListPokemon
import com.example.pokemon.data.remote.service.PokemonServiceImp
import com.example.pokemon.data.remote.repository.PokemonRepositoryRemoteImp
import com.example.pokemon.ui.viewmodel.DetailsFragmentViewModel
import com.example.pokemon.ui.viewmodel.ListFragmentViewModel
import com.example.pokemon.ui.viewmodel.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {
    viewModel {
        ListFragmentViewModel(get())
    }
    viewModel {
        SplashViewModel(get())
    }
    viewModel {
        DetailsFragmentViewModel(get())
    }
    single { get<PokemonsDataBase>().pokemonDao() }
    single {
        Room.databaseBuilder(get(), PokemonsDataBase::class.java, "pokemons_db")
            .fallbackToDestructiveMigration().build()
    }

    factory { PokemonRepositoryRemoteImp(get()) }
    factory { PokemonServiceImp(APIListPokemon.apiService) }

}