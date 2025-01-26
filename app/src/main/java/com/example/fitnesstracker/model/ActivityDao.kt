package com.example.fitnesstracker.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addActivity(activity: Activity)

    @Query("SELECT * FROM activities WHERE isMine = true")
    fun getMyActivities(): Flow<List<Activity>>

    @Query("SELECT * FROM activities")
    fun getActivities(): Flow<List<Activity>>
}