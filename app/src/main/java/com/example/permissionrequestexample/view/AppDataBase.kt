package com.example.permissionrequestexample.view

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.permissionrequestexample.view.room.HumanDao
import com.example.permissionrequestexample.view.room.HumanEntity

@Database(entities = [HumanEntity::class], version = 1)

abstract class AppDatabase: RoomDatabase() {

    abstract fun humanDao():HumanDao
}