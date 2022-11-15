package com.example.permissionrequestexample.view.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HumanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val lastName: String
)
