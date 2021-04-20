package com.example.pokemon.ui.view

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentDetailsBinding
import com.example.pokemon.ui.viewmodel.DetailsFragmentViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    lateinit var id: String
    var colorlight: Int? = null
    var colordark: Int?= null

    private val detailsViewModel by viewModel<DetailsFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shared = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = shared
        val binding: FragmentDetailsBinding = FragmentDetailsBinding.inflate(inflater,container, false)
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
        colorlight = safeArgs.colorlight
        colordark = safeArgs.colordark
        ViewCompat.setTransitionName(view?.findViewById(R.id.image_pokemon), "image${id}")
        setLayout()

    }

    private fun setLayout() {
        detailsViewModel.fetchPokemon(id)
        val image = view?.findViewById<ImageView>(R.id.image_pokemon)
        val url = "https://pokeres.bastionbot.org/images/pokemon/" + id + ".png"
        Picasso.get().load(url).into(image)
        val backgroundinfo : View? = view?.findViewById(R.id.background_info)
        colordark?.let { backgroundinfo?.background?.setTint(it) }
        val background : ConstraintLayout? = view?.findViewById(R.id.background_fragment)
        colorlight?.let { background?.setBackgroundColor(it) }

    }


}