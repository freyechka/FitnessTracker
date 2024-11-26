package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White

@Composable
fun BigButton(text: String) {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        shape = ShapeDefaults.ExtraSmall,
        colors = ButtonColors(
            containerColor = Primary,
            contentColor = White,
            disabledContainerColor = Gray,
            disabledContentColor = Gray
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(700),
            color = White
        )
    }
}