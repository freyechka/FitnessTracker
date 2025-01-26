package com.example.fitnesstracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.model.ActivityListItem
import com.example.fitnesstracker.model.ActivityRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ActivitiesViewModel(private val repository: ActivityRepository) : ViewModel() {
    var commentary by mutableStateOf("")
    var selected by  mutableStateOf(false)
    val titles = listOf("Бег", "Велосипед")
    val listMyActivities: StateFlow<List<ActivityListItem>> = repository.getMyActivities()
        .stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )
    val listActivities: StateFlow<List<ActivityListItem>> = repository.getActivities()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    fun addActivity(activity: Activity) {
        viewModelScope.launch {
            repository.addActivity(activity)
        }
    }

    fun onCommentaryChange(comm: String) {
        commentary = comm
    }
}