package com.example.fitnesstracker.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.ZoneId

class ActivityRepository(private val activityDao: ActivityDao) {

    fun getMyActivities(): Flow<List<ActivityListItem>> {
        return mapActivitiesToListItems(activityDao.getMyActivities())

    }

    fun getActivities(): Flow<List<ActivityListItem>> {
        return mapActivitiesToListItems(activityDao.getActivities())
    }

    suspend fun addActivity(activity: Activity) {
        activityDao.addActivity(activity)
    }
}

//private fun mapActivitiesToListItems(activities: Flow<List<Activity>>) : Flow<List<ActivityListItem>> {
//    return activities.map { items ->
//        mutableListOf<ActivityListItem>().apply {
//            val sortedItems = items.sortedByDescending { it.end }
//            sortedItems.groupBy { Instant.ofEpochMilli(it.end).atZone(ZoneId.systemDefault()).toLocalDate() }.forEach { (date, groupItems) ->
//                add(ActivityListItem.DataHeader(date))
//                groupItems.forEach { item ->
//                    add(ActivityListItem.ActivityItem(item))
//                }
//            }
//        }
//    }
//}

private fun mapActivitiesToListItems(activities: Flow<List<Activity>>) : Flow<List<ActivityListItem>> {
    return activities.map { items ->
        items.sortedByDescending { it.end }
            .groupBy { Instant.ofEpochMilli(it.end).atZone(ZoneId.systemDefault()).toLocalDate() }
            .flatMap { (date, groupItems) ->
                        listOf(ActivityListItem.DataHeader(date)) +
                        groupItems.map { item -> ActivityListItem.ActivityItem(item) }
            }
    }
}