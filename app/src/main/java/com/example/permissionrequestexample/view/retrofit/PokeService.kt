package com.example.permissionrequestexample.view.retrofit

import com.example.permissionrequestexample.view.retrofit.pokemodel.GenerationResponse
import com.example.permissionrequestexample.view.retrofit.pokemodel.data.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {

    @GET("pokemon")
    fun getFirstGenerationPokemon(@Query("limit") limit: Int = 151): Call<GenerationResponse?>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Call<Data>

}