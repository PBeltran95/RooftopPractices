package com.example.permissionrequestexample.view.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.retrofit.pokemodel.GenerationResponse
import com.example.permissionrequestexample.view.retrofit.pokemodel.Pokemon
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitFragment : Fragment(R.layout.fragment_retrofit), PokeNamesAdapter.PokemonClick {

    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy { PokeNamesAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callRetrofit()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.rv_pokemon_names)
        recyclerView.adapter = adapter
    }

    private fun callRetrofit() {
        val call = RetrofitBuilder.service.getFirstGenerationPokemon()

        call.enqueue( object : Callback<GenerationResponse?> {
            override fun onResponse(
                call: Call<GenerationResponse?>,
                response: Response<GenerationResponse?>
            ) {
                response.body()?.results?.let { drawPokemonNames(it) }
            }

            override fun onFailure(call: Call<GenerationResponse?>, t: Throwable) {
                Snackbar.make(requireView(),"Something wrong happened", Snackbar.LENGTH_SHORT).show()
                Log.d("retrofitFailure", t.message.toString())
            }
        } )
    }

    private fun drawPokemonNames(pokemons: List<Pokemon>) {
        adapter.setupData(pokemons.sortedBy { it.name })
    }

    override fun onPokemonNameClick(name: String) {
        val action = RetrofitFragmentDirections.actionRetrofitFragmentToPokemonDetailFragment(name)
        findNavController().navigate(action)
    }
}