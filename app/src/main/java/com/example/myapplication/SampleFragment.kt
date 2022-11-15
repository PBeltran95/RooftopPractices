package com.example.myapplication

import android.content.res.ColorStateList
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment

class SampleFragment(private val listener: OnSelectCountry) : Fragment(R.layout.fragment_sample) {

    private lateinit var wifiAnimation: AnimationDrawable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.selectCountry("Argentina")
            val imgAnimation = getView()?.findViewById<ImageView>(R.id.img_animation)
        imgAnimation?.setBackgroundResource(R.drawable.animation)

        ImageViewCompat.setImageTintList(imgAnimation!!, ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.purple_200)))

        wifiAnimation = imgAnimation.background as AnimationDrawable
    }

    override fun onResume() {
        super.onResume()
        wifiAnimation.start()
    }

    override fun onStop() {
        super.onStop()
        wifiAnimation.stop()
    }

}