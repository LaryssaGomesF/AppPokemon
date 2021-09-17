package com.example.pokemon.ui.adapter


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.data.remote.result.PokemonSafe
import com.example.pokemon.databinding.ItemRecyclerBinding
import com.example.pokemon.ui.view.ListFragmentDirections
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class PokemonListAdapter(var list: List<PokemonSafe>) : RecyclerView.Adapter<PokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        return PokemonHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recycler,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

}


class PokemonHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
    var colorlight: Int? = R.color.primary_color_light
    var colordark: Int? = R.color.dark_color_thema

    fun bind(pokemon: PokemonSafe) {
        binding.pokemon = pokemon
        val id = pokemon.id.toString()
        val url = pokemon.imageurl
        val image = binding.imagePokemon
        Picasso.get().load(url).into(image, object : Callback {
            override fun onSuccess() {
                loadPalette()
            }

            override fun onError(e: Exception?) {
            }
        })

        binding.root.setOnClickListener {
            val direction =
                colorlight?.let { colorlight ->
                    colordark?.let { colordark ->
                        ListFragmentDirections.infoAction(
                            id, colorlight,
                            colordark
                        )
                    }
                }
            ViewCompat.setTransitionName(it, "image${id}")
            val extras = FragmentNavigatorExtras(itemView to "image${id}")
            direction?.let { it1 -> it.findNavController().navigate(it1, extras) }
        }

    }

    private fun loadPalette() {
        val drawable: BitmapDrawable = binding.imagePokemon.drawable as BitmapDrawable
        val bitMap: Bitmap = drawable.bitmap
        val builder = Palette.Builder(bitMap)
        builder.generate { palette ->
            val lightMuted: Palette.Swatch? = palette?.lightMutedSwatch
            val muted: Palette.Swatch? = palette?.mutedSwatch

            if (lightMuted != null) {
                binding.background.background.setTint(lightMuted.rgb)
                binding.namePokemon.setTextColor(lightMuted.titleTextColor)
                colorlight = lightMuted.rgb
            } else if (muted != null) {
                binding.apply {
                    background.background.setTint(muted.rgb)
                    namePokemon.setTextColor(muted.titleTextColor)
                    colordark = muted.rgb
                }

            }
        }
    }
}
