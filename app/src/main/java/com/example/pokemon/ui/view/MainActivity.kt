package com.example.pokemon.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.local.asDomainModelList
import com.example.pokemon.domain.model.PokemonModel
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

        mainViewModel.fetchPokemons()
        observe()
    }

    private fun setRecycler(list: List<PokemonModel>) {
        recyclerView = findViewById(R.id.recycler)
        val layout =
            GridLayoutManager(applicationContext, 2)
        recyclerView?.layoutManager = layout
        recyclerView?.setHasFixedSize(true)
        adapter = PokemonListAdapter(list)
        recyclerView?.adapter = adapter
    }

   private fun observe() {
       mainViewModel.list.observe(this, Observer {
           setRecycler(it.asDomainModelList())
       })
   }
}