package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstracker.ui.theme.Gray

@Composable
fun PlaceholderWidget() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 320.dp)) {
            Text(
                text = "Время потренить",
                fontWeight = FontWeight(700),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Нажимай на кнопку ниже и начинаем трекать активность",
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                color = Gray,
                style = TextStyle.Default.copy(
                    lineBreak = LineBreak.Paragraph.copy(
                        strategy = LineBreak.Strategy.HighQuality
                    )
                ),
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 25.dp)
            )
        }
    }
}