package com.example.fitnesstracker.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Activity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ActivityDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao

}