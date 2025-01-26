package com.example.fitnesstracker.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Activity::class], version = 1, exportSchema = false)
abstract class ActivityDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao

}