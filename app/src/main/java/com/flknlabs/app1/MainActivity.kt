package com.flknlabs.app1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imgPoster)
    }

    override fun onResume() {
        super.onResume()
        request()
    }

    fun loadImage(imagePath: String) {
        Glide
            .with(this)
            .load(IMAGE_BASE_URL + imagePath)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(imageView)
    }

    fun request() {
        val apiClient = ApiClient()
        val call = apiClient.movieDatabaseAPI.getMovies(600, BuildConfig.API_KEY)

        call.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                val json = Gson().toJson(response.body())
                Log.d("MainActivity", "Response: $json")
                loadImage(response.body()?.poster_path ?: "")
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.d("MainActivity","Error: ${t.stackTrace}}")
                loadImage( "")
            }
        })
    }
}

