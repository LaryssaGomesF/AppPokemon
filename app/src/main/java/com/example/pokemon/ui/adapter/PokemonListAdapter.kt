package com.example.pokemon.ui.adapter

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R
import com.example.pokemon.domain.model.PokemonModel
import com.squareup.picasso.Picasso

class PokemonListAdapter(var list: List<PokemonModel>) : RecyclerView.Adapter<PokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return PokemonHolder(item)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val id = list.get(position).id.toString()
        val url = "https://pokeres.bastionbot.org/images/pokemon/"+id+".png"
        holder.name.text = list.get(position).name
        val image = holder.image
        Picasso.get().load(url).into(image)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView = itemView.findViewById(R.id.image_pokemon)
    var name: TextView = itemView.findViewById(R.id.name_pokemon)
}