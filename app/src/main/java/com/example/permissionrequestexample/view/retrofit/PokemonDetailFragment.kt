package com.example.permissionrequestexample.view.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.retrofit.pokemodel.data.Data
import com.example.permissionrequestexample.view.utils.capitalize
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail) {

    private val args by navArgs<PokemonDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeCall()
    }

    private fun makeCall() {
        RetrofitBuilder.service.getPokemon(args.pokemonUrl).enqueue(
            object: Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    drawDetails(response.body())
                }
                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Snackbar.make(requireView(),"Something wrong happened", Snackbar.LENGTH_SHORT).show()
                    Log.d("retrofitFailure", t.message.toString())
                }
            }
        )
    }

    private fun drawDetails(pokemonData: Data?) {
        val tvName: TextView = requireView().findViewById(R.id.tv_title)
        val tvType: TextView = requireView().findViewById(R.id.tv_type)
        val tvHeight: TextView = requireView().findViewById(R.id.tv_height)
        val tvWeight: TextView = requireView().findViewById(R.id.tv_weight)
        val tvDescription: TextView = requireView().findViewById(R.id.tv_description)
        val imgFront: ImageView = requireView().findViewById(R.id.img_front)
        val imgBack: ImageView = requireView().findViewById(R.id.img_back)
        pokemonData?.let {
            tvName.text = pokemonData.name.capitalize()
            tvType.text = pokemonData.types.first().type.name.capitalize() ?: ""
            tvHeight.text = pokemonData.height.toString() + "ft"
            tvWeight.text = pokemonData.weight.toString() + "lbs"
            tvDescription.text = pokemonData.stats.joinToString()
            imgFront.load(pokemonData.sprites.front_default){
                crossfade(true)
                crossfade(1000)
            }
            imgBack.load(pokemonData.sprites.back_default) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

}