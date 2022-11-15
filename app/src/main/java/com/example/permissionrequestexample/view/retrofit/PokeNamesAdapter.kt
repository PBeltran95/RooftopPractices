package com.example.permissionrequestexample.view.retrofit

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.retrofit.pokemodel.Pokemon
import com.example.permissionrequestexample.view.utils.capitalize

class PokeNamesAdapter(private val callBack: PokemonClick): RecyclerView.Adapter<PokeNamesAdapter.PokeNameViewHolder>() {

    interface PokemonClick {
        fun onPokemonNameClick(name: String)
    }

    private var pokemonNames: List<Pokemon> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setupData(pokemons: List<Pokemon>) {
        this.pokemonNames = pokemons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeNameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokeNameViewHolder(layoutInflater.inflate(R.layout.item_human, parent, false))
    }

    override fun onBindViewHolder(holder: PokeNameViewHolder, position: Int) {
        val item = pokemonNames[position]
        with(holder){
            tvPokemonName.text = item.name.capitalize()
            root.setOnClickListener {
                callBack.onPokemonNameClick(item.name)
            }
        }
    }

    override fun getItemCount(): Int = pokemonNames.size


    inner class PokeNameViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val root: View = view.rootView
        val tvPokemonName: TextView = view.findViewById<TextView>(R.id.tv_name)
    }
}