package com.example.pokemon.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemon.data.remote.result.PokemonSafe
import com.example.pokemon.databinding.FragmentListBinding
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
        ListViewModel.errorListPokemon.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "Error para carregar pokemons", Toast.LENGTH_SHORT)
                .show()
        })
    }


}