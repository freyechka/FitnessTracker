package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Sports
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.ui.screen.ActivityScreen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Активность", "Профиль")
    val selectedIcons = listOf(Icons.Filled.Sports, Icons.Filled.Person)

    NavigationBar(containerColor = White) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        selectedIcons[index],
                        contentDescription = item,
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
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
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            BottomNavigationBar()
        }
    }
}