package com.example.fitnesstracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "activities")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val start: Long, // время начала в мс
    val end: Long, // время завершения в мс
    val title: String, // тип
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


