package com.example.fitnesstracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class TabsViewModel {
    var tabIndex by mutableStateOf(0)
    val tabs = listOf("Моя", "Пользователей")
}