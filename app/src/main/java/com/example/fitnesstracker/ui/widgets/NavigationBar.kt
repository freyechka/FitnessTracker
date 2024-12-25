package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.navigation.BottomBarScreen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White
import com.example.fitnesstracker.viewmodel.TabsViewModel

@Composable
fun BottomNavigationBar(tabsViewModel: TabsViewModel, navController: NavController) {
    val selectedIcons = listOf(Icons.Filled.Sports, Icons.Filled.Person)
    val screens = listOf(
        BottomBarScreen.Activity,
        BottomBarScreen.Profile
    )
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    NavigationBar(containerColor = White) {
        screens.forEach{screen ->
        AddItem(screen = screen,
            navDestination = currentDestination,
            navController = navController)}
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            BottomNavigationBar(tabsViewModel = TabsViewModel(),
                navController = rememberNavController())
        }
    }
}

@Composable
private fun RowScope.AddItem(
    screen: BottomBarScreen,
    navDestination: NavDestination?,
    navController: NavController
) {
    NavigationBarItem(
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "NavBar icon")
        },
        label = {
            Text(text = screen.title)
        },
        selected = navDestination?.hierarchy?.any { it.route == screen.route} == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemColors(
            selectedIconColor = Primary,
            selectedTextColor = Color.Black,
            selectedIndicatorColor = White,
            unselectedIconColor = Gray,
            unselectedTextColor = Gray,
            disabledIconColor = Gray,
            disabledTextColor = Gray
        )
    )
}