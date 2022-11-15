package com.example.permissionrequestexample.view.retrofit

import com.example.permissionrequestexample.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        lateinit var retrofit: Retrofit
        lateinit var service: PokeService
    }

    init {
        retrofit = getRetrofit()
        service = initService()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initService(): PokeService = retrofit.create(PokeService::class.java)

}