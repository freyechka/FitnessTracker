package com.example.fitnesstracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.ui.screen.LoginScreen
import com.example.fitnesstracker.ui.screen.RegistrationScreen
import com.example.fitnesstracker.ui.screen.WelcomeScreen
import com.example.fitnesstracker.viewmodel.LoginViewModel

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object Registration : Screen("registration")
    data object Login : Screen("login")
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
    }
}