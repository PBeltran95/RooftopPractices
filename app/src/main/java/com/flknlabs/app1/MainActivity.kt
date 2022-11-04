package com.flknlabs.app1

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var chipContainer: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imgBackground)
        chipContainer = findViewById<ChipGroup>(R.id.category_container)
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
        val call = apiClient.movieDatabaseAPI.getMovies(25010, BuildConfig.API_KEY)

        call.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                val json = Gson().toJson(response.body())
                drawMovie(response.body())
                Log.d("MainActivity", "Response: $json")
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                Log.d("MainActivity","Error: ${t.stackTrace}}")
                loadImage( "")
            }
        })
    }

    private fun drawMovie(body: BaseResponse?) {
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvProfessionalRate = findViewById<TextView>(R.id.tv_professional_rate)
        val tvReviews = findViewById<TextView>(R.id.tv_reviews)
        val tvReviewsTotal = findViewById<TextView>(R.id.tv_reviews_total)
        val tvDescription = findViewById<TextView>(R.id.tv_description)
        tvTitle.text = body?.title
        tvProfessionalRate.text = body?.status
        tvReviews.text = body?.vote_average.toString()
        tvReviewsTotal.text = "(${body?.vote_count.toString()} reviews)"
        tvDescription.text = body?.overview
        loadImage(body?.poster_path ?: "")
        body?.genres?.forEach { addChip(it.name) }
    }

    private fun addChip(genre: String) {
        val chip = Chip(this)
        with(chip){
            text = genre
            typeface = Typeface.DEFAULT_BOLD
            isClickable = false
            chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity, R.color.gray))
            setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
        }
        chipContainer.addView(chip)
    }
}

