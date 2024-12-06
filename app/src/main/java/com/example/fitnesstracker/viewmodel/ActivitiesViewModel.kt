package com.example.fitnesstracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.model.ActivityListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ActivitiesViewModel {
    var commentary by mutableStateOf("")
    private val _communityActivities = MutableStateFlow<List<ActivityListItem>>(emptyList())
    private val _myActivities = MutableStateFlow<List<ActivityListItem>>(emptyList())

    val communityActivities: StateFlow<List<ActivityListItem>> get() = _communityActivities
    val myActivities: StateFlow<List<ActivityListItem>> get() = _myActivities

    init {
        loadActivities()
    }

    private fun loadActivities() {
        val communityActivities = listOf(
            Activity(1, 10.32, "2 часа", "13:33", "15:33", "Квадробинг", "11.11.2024", false, "@shunnex"),
            Activity(2, 22.8, "13 часов", "03:44", "16:44", "Хоббихорсинг", "17.11.2024", false, "@frost")
        )
        val myActivities = listOf(
            Activity(1, 10.32, "2 часа", "13:33", "15:33", "Пробежка", "17.07.2024", true, "@freyechka"),
            Activity(2, 22.8, "13 часов", "03:44", "16:44", "Серфинг", "17.07.2024", true, "@freyechka")
        )

        val groupedCommunityActivities = communityActivities.groupBy { it.date }
        val communityItems = mutableListOf<ActivityListItem>()

        groupedCommunityActivities.forEach { (date, activities) ->
            communityItems.add(ActivityListItem.DataHeader(date))
            communityActivities.forEach { activity ->
                communityItems.add(ActivityListItem.ActivityItem(activity))
            }
        }

        _communityActivities.value = communityItems


        val groupedMyActivities = myActivities.groupBy { it.date }
        val myItems = mutableListOf<ActivityListItem>()

        groupedMyActivities.forEach { (date, activities) ->
            myItems.add(ActivityListItem.DataHeader(date))
            myActivities.forEach { activity ->
                myItems.add(ActivityListItem.ActivityItem(activity))
            }
        }

        _myActivities.value = myItems
    }

    fun onCommentaryChange(comm: String) {
        commentary = comm
    }
}