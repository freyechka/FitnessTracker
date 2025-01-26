package com.example.fitnesstracker.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fitnesstracker.model.ActivityListItem
import com.example.fitnesstracker.ui.screen.ChangePasswordScreen
import com.example.fitnesstracker.ui.screen.CommunityActivityDetailsScreen
import com.example.fitnesstracker.ui.screen.HubScreen
import com.example.fitnesstracker.ui.screen.LoginScreen
import com.example.fitnesstracker.ui.screen.MyActivityDetailsScreen
import com.example.fitnesstracker.ui.screen.NewActivityScreen
import com.example.fitnesstracker.ui.screen.RegistrationScreen
import com.example.fitnesstracker.ui.screen.WelcomeScreen
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object Registration : Screen("registration")
    data object Login : Screen("login")
    data object MyDetails : Screen("myDetails/{activityId}")
    data object CommunityDetails : Screen("communityDetails/{activityId}")
    data object ChangePassword : Screen("changePassword")
    data object NewActivity : Screen("newActivity")
    data object Hub : Screen("hub")
}

@Composable
fun NavGraph(vm: ActivitiesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController, viewModel())
        }
        composable(Screen.Login.route) {
            LoginScreen(navController, viewModel())
        }
        composable(Screen.Hub.route) {
            HubScreen(navController, vm)
        }
        composable(Screen.ChangePassword.route) {
            ChangePasswordScreen(navController, viewModel())
        }
        composable(Screen.NewActivity.route) {
            NewActivityScreen(navController, vm)
        }
        composable(Screen.MyDetails.route, arguments = listOf(navArgument("activityId") { type = NavType.IntType})
        ) {
            val activityId = it.arguments?.getInt("activityId")
            val viewModel: ActivitiesViewModel = vm
            val activities = viewModel.listMyActivities.value ?: emptyList()
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
            val viewModel: ActivitiesViewModel = vm
            val activities = viewModel.listActivities.value ?: emptyList()
            val activityItem = activities
                .filterIsInstance<ActivityListItem.ActivityItem>()
                .firstOrNull { t -> t.activity.id == activityId }
            if (activityItem != null) {
                CommunityActivityDetailsScreen(activityItem.activity, navController, viewModel)
            }
        }
    }
}