package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.navigation.Screen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel
import com.example.fitnesstracker.viewmodel.TabsViewModel

@Composable
fun ActivityScreen(navController: NavController, tabsViewModel: TabsViewModel) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.NewActivity.route) },
                contentColor = White,
                shape = CircleShape,
                containerColor = Primary
            ) {
                    Icon(Icons.Rounded.PlayArrow, contentDescription = "idk")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)) {
            TabRow(
                selectedTabIndex = tabsViewModel.tabIndex,
                divider = {}
            ) {
                tabsViewModel.tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selectedContentColor = Primary,
                        unselectedContentColor = Gray,
                        selected = tabsViewModel.tabIndex == index,
                        onClick = { tabsViewModel.tabIndex = index }
                    )
                }
            }
            when (tabsViewModel.tabIndex) {
                0 -> MyActivityScreen(
                    activitiesViewModel = ActivitiesViewModel(),
                    onActivityClick = { activity -> navController.navigate("myDetails/${activity.id}") }
                )

                1 -> CommunityActivityScreen(
                    activitiesViewModel = ActivitiesViewModel(),
                    onActivityClick = { activity -> navController.navigate("communityDetails/${activity.id}") }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewActivityScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ActivityScreen(
                navController = rememberNavController(),
                tabsViewModel = TabsViewModel()
            )
        }
    }
}