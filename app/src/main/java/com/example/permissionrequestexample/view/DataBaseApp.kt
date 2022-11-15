package com.example.permissionrequestexample.view

import android.app.Application
import android.content.Context
import androidx.room.Room

class DataBaseApp: Application() {
    companion object {
        private var dataBase: AppDatabase? = null

        fun getInMemoryDatabase(context: Context): AppDatabase {
            dataBase = dataBase ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "HumanDataBase").build()
            return dataBase!!
        }
    }
}