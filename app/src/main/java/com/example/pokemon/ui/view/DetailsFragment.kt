package com.example.pokemon.ui.view

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokemon.R

class DetailsFragment : Fragment() {
    lateinit var id: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shared = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = shared
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: DetailsFragmentArgs by navArgs()
        id = safeArgs.id
        ViewCompat.setTransitionName(view?.findViewById(R.id.image_pokemon), "image${id}")
    }

    private fun setLayout(){

    }
}