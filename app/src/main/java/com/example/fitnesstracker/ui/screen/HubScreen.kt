package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.navigation.BottomBarNavGraph
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.widgets.BottomNavigationBar

@Composable
fun HubScreen(internalNavController: NavController) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigationBar(viewModel(), navController)},
        topBar = {}
        ) {
        innerPadding ->
        BottomBarNavGraph(navController = navController, internalNavController = internalNavController, innerPadding.onlyBottom())
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHubScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            HubScreen(
                internalNavController = rememberNavController()
            )
        }
    }
}

@Composable
private fun PaddingValues.onlyBottom() : PaddingValues {
    return PaddingValues(
        top = 0.dp,
        bottom = calculateBottomPadding(),
        end = 0.dp,
        start = 0.dp
    )
}