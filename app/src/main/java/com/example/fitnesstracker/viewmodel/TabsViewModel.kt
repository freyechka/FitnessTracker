package com.example.fitnesstracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TabsViewModel : ViewModel() {
    var tabIndex by mutableStateOf(0)
    val tabs = listOf("Моя", "Пользователей")

}