package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White
import com.example.fitnesstracker.ui.widgets.TopAppBarWidget
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel

@Composable
fun MyActivityDetailsScreen(activity: Activity, navController: NavController, activitiesViewModel: ActivitiesViewModel) {
    Scaffold(
        topBar = {
            TopAppBarWidget(
                navController = navController,
                actions = { Actions() },
                title = activity.title
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)
            .padding(20.dp)) {
            Text(
                text = activity.distance.toString() + " км",
                fontWeight = FontWeight(700),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = activity.date,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = activity.duration,
                fontWeight = FontWeight(700),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.size(height = 24.dp, width = 233.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Старт",
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp
                )
                Text(
                    text = activity.start,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Text(
                    text = "|",
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Финиш",
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp
                )
                Text(
                    text = activity.end,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = activitiesViewModel.commentary,
                onValueChange = { activitiesViewModel.onCommentaryChange(it) },
                label = { Text(
                    text = "Комментарий",
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    color = Gray
                )
                }, modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyActivityDetailsScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            MyActivityDetailsScreen(
                activity = Activity(
                    id = 1,
                    distance = 14.32,
                    duration = "5 часов",
                    start = "14:39",
                    end = "19:39",
                    title = "Серфинг",
                    date = "03.12.2024",
                    isMine = true,
                    author = "@boberkurwa",
                ),
                navController = rememberNavController(),
                activitiesViewModel = ActivitiesViewModel()
            )
        }
    }
}

@Composable
private fun Actions() {
    IconButton(
        onClick = {},
        colors = IconButtonColors(
            containerColor = White,
            contentColor = Primary,
            disabledContainerColor = White,
            disabledContentColor = Gray
        )
    ) {
        Icon(
            Icons.Filled.Delete,
            contentDescription = "Delete the activity"
        )
    }
    IconButton(
        onClick = {},
        colors = IconButtonColors(
            containerColor = White,
            contentColor = Primary,
            disabledContainerColor = White,
            disabledContentColor = Gray
        )
    ) {
        Icon(
            Icons.Filled.Share,
            contentDescription = "Share the activity"
        )
    }
}