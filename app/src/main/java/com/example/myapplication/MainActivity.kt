package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnSelectCountry {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = SampleFragment(this)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun selectCountry(country: String) {
        Toast.makeText(this, "El pais de este es: $country", Toast.LENGTH_SHORT).show()
    }
}

interface OnSelectCountry {
    fun selectCountry(country: String)
}