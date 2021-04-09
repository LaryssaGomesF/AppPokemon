package com.example.pokemon.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.local.asDomainModelList
import com.example.pokemon.domain.model.PokemonModel
import com.example.pokemon.ui.adapter.PokemonListAdapter
import com.example.pokemon.ui.viewmodel.ListFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment: Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: PokemonListAdapter? = null
    private val mainViewModel by viewModel<ListFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun setRecycler(list: List<PokemonModel>) {
        recyclerView = view?.findViewById(R.id.recycler)
        val layout =
            GridLayoutManager(requireContext(), 2)
        recyclerView?.layoutManager = layout
        recyclerView?.setHasFixedSize(true)
        adapter = PokemonListAdapter(list)
        recyclerView?.adapter = adapter
    }

    private fun observe() {
        mainViewModel.list.observe(requireActivity(), Observer {
            setRecycler(it.asDomainModelList())
        })
    }
}