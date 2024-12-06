package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray

@Composable
fun DateHeader(date: String) {
    Text(
        text = date,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight(400),
        color = Gray
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDateHeader() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            DateHeader("Вчера")
        }
    }
}