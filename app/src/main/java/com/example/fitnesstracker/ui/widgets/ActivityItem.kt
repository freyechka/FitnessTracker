package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White

@Composable
fun ActivityItem(activity: Activity, onItemClick: (Activity) -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(activity) }
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp
            ),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardColors(
            containerColor = White,
            contentColor = Color.Black,
            disabledContentColor = White,
            disabledContainerColor = Gray
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = activity.distance.toString() + " км",
                    fontWeight = FontWeight(700),
                    fontSize = 24.sp
                )
                if (!activity.isMine) {
                    Text(
                        text = activity.author,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        color = Primary
                    )
                }
            }
            Text(
                text = activity.duration,
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = activity.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = activity.date,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewActivityItem() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ActivityItem(
                Activity(
                    id = 1,
                    distance = 14.32,
                    duration = "5 часов",
                    start = "14:39",
                    end = "19:39",
                    title = "Серфинг",
                    date = "03.12.2024",
                    isMine = true,
                    author = "@boberkurwa"
                ),
                onItemClick = {}
            )
        }
    }
}