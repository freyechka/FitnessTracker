package com.example.fitnesstracker.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.ZoneId

class ActivityRepository(private val activityDao: ActivityDao) {

    fun getMyActivities(): Flow<List<ActivityListItem>> {
        return activityDao.getMyActivities()
            .map { items ->
                mutableListOf<ActivityListItem>().apply {
                    val sortedItems = items.sortedByDescending { it.end }
                    sortedItems.groupBy { Instant.ofEpochMilli(it.end).atZone(ZoneId.systemDefault()).toLocalDate() }.forEach { (date, groupItems) ->
                        add(ActivityListItem.DataHeader(date))
                        groupItems.forEach { item ->
                            add(ActivityListItem.ActivityItem(item))
                        }
                    }
                }
            }
    }

    fun getActivities(): Flow<List<ActivityListItem>> {
        return activityDao.getActivities().map { items ->
            mutableListOf<ActivityListItem>().apply {
                val sortedItems = items.sortedByDescending { it.end }
                sortedItems.groupBy { Instant.ofEpochMilli(it.end).atZone(ZoneId.systemDefault()).toLocalDate() }.forEach { (date, groupItems) ->
                    add(ActivityListItem.DataHeader(date))
                    groupItems.forEach { item ->
                        add(ActivityListItem.ActivityItem(item))
                    }
                }
            }
        }
    }

    suspend fun addActivity(activity: Activity) {
        activityDao.addActivity(activity)
    }
}