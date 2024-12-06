package com.example.fitnesstracker.model

data class Activity(
    val id: Int,
    val distance: Double, // in meters
    val duration: String,
    val start: String,
    val end: String,
    val title: String,
    val date: String,
    val isMine: Boolean,
    val author: String,
)

sealed class ActivityListItem {
    data class DataHeader(val date: String) : ActivityListItem()
    data class ActivityItem(val activity: Activity) : ActivityListItem()
}