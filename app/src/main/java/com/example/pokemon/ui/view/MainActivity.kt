package com.example.pokemon.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.ui.adapter.PokemonListAdapter
import com.example.pokemon.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: PokemonListAdapter? = null
    private val mainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setRecycler()
       // mainViewModel.fetchPokemons()
    }

    private fun setRecycler() {
        recyclerView = findViewById(R.id.recycler)
        val layout =
            GridLayoutManager(applicationContext, 2)
        recyclerView?.layoutManager = layout
        recyclerView?.setHasFixedSize(true)
        var list = list()
        adapter = PokemonListAdapter(list)
        recyclerView?.setItemViewCacheSize(10)
        recyclerView?.adapter = adapter
    }

    private fun list(): ArrayList<String> {
        var list: ArrayList<String> = arrayListOf()
        for (i in 0..6) {
            list.add("NOME")
        }
        return list
    }
}