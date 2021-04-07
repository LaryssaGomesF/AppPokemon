package com.example.pokemon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.R

class PokemonListAdapter(var list: List<String>) : RecyclerView.Adapter<PokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return PokemonHolder(item)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.name.text = list.get(position)
        holder.image.setImageResource(R.drawable.teste)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView = itemView.findViewById(R.id.image_pokemon)
    var name: TextView = itemView.findViewById(R.id.name_pokemon)
}