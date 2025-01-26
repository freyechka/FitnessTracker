package com.example.fitnesstracker.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnesstracker.ui.screen.ActivityScreen
import com.example.fitnesstracker.ui.screen.ProfileScreen
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel

sealed class BottomBarScreen(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    data object Activity : BottomBarScreen(
        route = "activity",
        icon = Icons.Filled.Sports,
        title = "Активность"
    )
    data object Profile : BottomBarScreen(
        route = "profile",
        icon = Icons.Filled.Person,
        title = "Профиль"
    )
}

@Composable
fun BottomBarNavGraph(navController: NavHostController, internalNavController: NavController, padding: PaddingValues, vm: ActivitiesViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Activity.route,
        modifier = Modifier.padding(padding)
    ) {
       composable(route = BottomBarScreen.Activity.route) {
           ActivityScreen(internalNavController, viewModel(), vm)
       }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(internalNavController, viewModel())
        }
    }
}