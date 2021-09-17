package com.example.pokemon.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.data.local.asDomainModelList
import com.example.pokemon.data.remote.PokemonRaw
import com.example.pokemon.data.remote.PokemonSafe
import com.example.pokemon.databinding.FragmentDetailsBinding
import com.example.pokemon.databinding.FragmentListBinding
import com.example.pokemon.domain.model.PokemonModel
import com.example.pokemon.ui.adapter.PokemonListAdapter
import com.example.pokemon.ui.viewmodel.ListFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val ListViewModel by viewModel<ListFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = ListViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ListViewModel.fetchPokemons()
        observe()
    }

    private fun setRecycler(list: List<PokemonSafe>) {
        val layout =
            GridLayoutManager(requireContext(), 2)
        binding.recycler.apply {
            layoutManager = layout
            setHasFixedSize(true)
            adapter = PokemonListAdapter(list)
        }
    }

    private fun observe() {
        ListViewModel.successListPokemon.observe(viewLifecycleOwner, Observer {
            setRecycler(it)
        })
    }


}