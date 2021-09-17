package com.example.pokemon.ui.view

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentDetailsBinding
import com.example.pokemon.ui.viewmodel.DetailsFragmentViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    lateinit var id: String
    lateinit var url: String
    var colorlight: Int? = null
    var colordark: Int?= null
    private val detailsViewModel by viewModel<DetailsFragmentViewModel>()
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shared = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = shared
        binding = FragmentDetailsBinding.inflate(inflater,container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@DetailsFragment.detailsViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: DetailsFragmentArgs by navArgs()
        id = safeArgs.id
        url = safeArgs.url
        colorlight = safeArgs.colorlight
        colordark = safeArgs.colordark
        ViewCompat.setTransitionName(view?.findViewById(R.id.image_pokemon), "image${id}")
        setLayout()
        observe()

    }

    private fun setLayout() {
        detailsViewModel.fetchPokemon(id)
        Picasso.get().load(url).into(binding.imagePokemon)
        colordark?.let { binding.backgroundInfo.background.setTint(it) }
        colorlight?.let { binding.backgroundFragment.background?.setTint(it) }


    }
    fun observe(){
        detailsViewModel.pokemon.observe(viewLifecycleOwner, Observer {
            binding.progressBarBaseExperience.progress = it.baseExp.toInt()
            binding.progressBarSpeed.progress = it.speed
            binding.progressBarSpeed.progress = it.speed
        })
    }


}