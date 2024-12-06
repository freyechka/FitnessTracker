package com.example.fitnesstracker.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fitnesstracker.model.ActivityListItem
import com.example.fitnesstracker.ui.screen.ActivityScreen
import com.example.fitnesstracker.ui.screen.CommunityActivityDetailsScreen
import com.example.fitnesstracker.ui.screen.LoginScreen
import com.example.fitnesstracker.ui.screen.MyActivityDetailsScreen
import com.example.fitnesstracker.ui.screen.RegistrationScreen
import com.example.fitnesstracker.ui.screen.WelcomeScreen
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel
import com.example.fitnesstracker.viewmodel.LoginViewModel
import com.example.fitnesstracker.viewmodel.TabsViewModel

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object Registration : Screen("registration")
    data object Login : Screen("login")
    data object Activities : Screen("activities")
    data object MyDetails : Screen("myDetails/{activityId}")
    data object CommunityDetails : Screen("communityDetails/{activityId}")
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController, LoginViewModel())
        }
        composable(Screen.Login.route) {
            LoginScreen(navController, LoginViewModel())
        }
        composable(Screen.Activities.route) {
            ActivityScreen(navController, tabsViewModel = TabsViewModel())
        }
        composable(Screen.MyDetails.route, arguments = listOf(navArgument("activityId") { type = NavType.IntType})
        ) {
            val activityId = it.arguments?.getInt("activityId")
            val viewModel: ActivitiesViewModel = ActivitiesViewModel()
            val activities = viewModel.myActivities.value ?: emptyList()
            val activityItem = activities
                .filterIsInstance<ActivityListItem.ActivityItem>()
                .firstOrNull { t -> t.activity.id == activityId }
            if (activityItem != null) {
                MyActivityDetailsScreen(activityItem.activity, navController, viewModel)
            }
        }
        composable(Screen.CommunityDetails.route, arguments = listOf(navArgument("activityId") { type = NavType.IntType})
        ) {
            val activityId = it.arguments?.getInt("activityId")
            val viewModel: ActivitiesViewModel = ActivitiesViewModel()
            val activities = viewModel.communityActivities.value ?: emptyList()
            val activityItem = activities
                .filterIsInstance<ActivityListItem.ActivityItem>()
                .firstOrNull { t -> t.activity.id == activityId }
            if (activityItem != null) {
                CommunityActivityDetailsScreen(activityItem.activity, navController, viewModel)
            }
        }
    }
}