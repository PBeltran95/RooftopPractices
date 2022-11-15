package com.example.permissionrequestexample.view.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HumanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHuman(humanEntity: HumanEntity)

    @Query("SELECT * from HumanEntity")
    fun recoverHumanThatMatches(): List<HumanEntity>

}