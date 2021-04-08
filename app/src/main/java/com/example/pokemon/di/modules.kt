package com.example.pokemon.di

import androidx.room.Room
import com.example.pokemon.data.local.PokemonsDataBase
import com.example.pokemon.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {
    viewModel {
        MainViewModel()
    }
    single { get<PokemonsDataBase>().pokemonDao() }
    single {
        Room.databaseBuilder(get(), PokemonsDataBase::class.java, "pokemons_db")
            .fallbackToDestructiveMigration().build()
    }

}