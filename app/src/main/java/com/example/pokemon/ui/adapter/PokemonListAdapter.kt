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
import com.example.pokemon.data.local.PokemonEntity
import com.example.pokemon.databinding.ItemRecyclerBinding
import com.example.pokemon.ui.view.ListFragmentDirections
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class PokemonListAdapter(var list: List<PokemonEntity>) : RecyclerView.Adapter<PokemonHolder>() {
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
    var colorlight: Int? = null
    var colordark: Int? = null

    fun bind(pokemon: PokemonEntity) {
        binding.pokemon = pokemon
        val id = pokemon.id.toString()
        val url = "https://pokeres.bastionbot.org/images/pokemon/" + id + ".png"

        Picasso.get().load(url).into(binding.imagePokemon, object : Callback {
            override fun onSuccess() {
                loadPalette()
            }

            override fun onError(e: Exception?) {
            }
        })

        binding.root.setOnClickListener {

            val direction =
                colorlight?.let { it1 -> colordark?.let { it2 ->
                    ListFragmentDirections.infoAction(id, it1,
                        it2
                    )
                } }
            ViewCompat.setTransitionName(it, "image${id}")
            val extras = FragmentNavigatorExtras(itemView to "image${id}")
            direction?.let { it1 -> it.findNavController().navigate(it1, extras) }
        }

    }
    private fun loadPalette() {
        val drawable: BitmapDrawable = binding.imagePokemon.drawable as BitmapDrawable
        val bitMap: Bitmap = drawable.bitmap
        val builder = Palette.Builder(bitMap)
        builder.generate(object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                var lightMuted: Palette.Swatch? = palette?.lightMutedSwatch
                var muted: Palette.Swatch? = palette?.mutedSwatch
                colorlight = lightMuted?.rgb
                colordark = muted?.rgb
                if (lightMuted != null) {
                    binding.background.background.setTint(lightMuted.rgb)
                    binding.namePokemon.setTextColor(lightMuted.titleTextColor)
                } else if (muted != null) {
                    binding.apply {
                        background.background.setTint(muted.rgb)
                        namePokemon.setTextColor(muted.titleTextColor)
                    }

                }

            }
        })
    }
}


//class PokemonHolder(binding: FragmentListBinding) : RecyclerView.ViewHolder(binding.root) {
//    var image: ImageView = itemView.findViewById(R.id.image_pokemon)
//    var name: TextView = itemView.findViewById(R.id.name_pokemon)
//    var background:ConstraintLayout = itemView.findViewById(R.id.background)
//    var colorlight: Int? = null
//    var colordark: Int? = null
//    val binding = binding
//
//    fun bind(pokemon: PokemonEntity) {
//        binding.root.id
//        val id = pokemon.id.toString()
//        val url = "https://pokeres.bastionbot.org/images/pokemon/" + id + ".png"
//        name.text = pokemon.name
//        val image = image
//        Picasso.get().load(url).into(image, object : Callback {
//            override fun onSuccess() {
//                loadPalette()
//            }
//
//            override fun onError(e: Exception?) {
//            }
//        })
//        itemView.setOnClickListener {
//            val id = pokemon.id.toString()
//            val direction =
//                colorlight?.let { it1 -> colordark?.let { it2 ->
//                    ListFragmentDirections.infoAction(id, it1,
//                        it2
//                    )
//                } }
//            ViewCompat.setTransitionName(it, "image${pokemon.id}")
//            val extras = FragmentNavigatorExtras(itemView to "image${pokemon.id}")
//            direction?.let { it1 -> it.findNavController().navigate(it1, extras) }
//        }
//    }
//
//
//
//    private fun loadPalette() {
//        val drawable: BitmapDrawable = image.drawable as BitmapDrawable
//        val bitMap: Bitmap = drawable.bitmap
//        val builder = Palette.Builder(bitMap)
//        builder.generate(object : Palette.PaletteAsyncListener {
//            override fun onGenerated(palette: Palette?) {
//                var lightMuted: Palette.Swatch? = palette?.lightMutedSwatch
//                var muted: Palette.Swatch? = palette?.mutedSwatch
//                colorlight = lightMuted?.rgb
//                colordark = muted?.rgb
//                if (lightMuted != null) {
//                    background?.background.setTint(lightMuted.rgb)
//                    name.setTextColor(lightMuted.titleTextColor)
//                } else if (muted != null) {
//                    background?.background.setTint(muted.rgb)
//                    name.setTextColor(muted.titleTextColor)
//                }
//
//            }
//        })
//    }
//}