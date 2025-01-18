package com.example.fitnesstracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Entity(tableName = "activities")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val duration: String,
    val start: String,
    val end: String,
    val title: String,
    val date: LocalDate,
    val isMine: Boolean,
    val author: String,
    val startLatitude: Double,
    val endLatitude: Double,
    val startLongitude: Double,
    val endLongitude: Double
    )

sealed class ActivityListItem {
    data class DataHeader(val date: LocalDate) : ActivityListItem()
    data class ActivityItem(val activity: Activity) : ActivityListItem()
}


