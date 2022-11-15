package com.example.permissionrequestexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.retrofit.RetrofitBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
        initRetrofit()
    }

    private fun initRetrofit() {
        RetrofitBuilder()
    }

    private fun initNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
    }
}