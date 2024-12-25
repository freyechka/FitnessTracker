package com.example.fitnesstracker.ui.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(navController: NavController, title: String, actions: @Composable RowScope.() -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Start,
                fontSize = 20.sp
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
                colors = IconButtonColors(
                    containerColor = White,
                    contentColor = Primary,
                    disabledContainerColor = Gray,
                    disabledContentColor = Gray
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous Page"
                )
            }
        },
        actions = actions


    )
}