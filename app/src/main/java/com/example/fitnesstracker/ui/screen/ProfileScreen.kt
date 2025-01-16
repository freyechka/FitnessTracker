package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.navigation.Screen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White
import com.example.fitnesstracker.ui.widgets.LoginTextField
import com.example.fitnesstracker.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Профиль",
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    TextButton({}) {
                        Text(text = "Сохранить",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(700),
                             color = Primary)
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 20.dp
                    )
            ) {
                LoginTextField(
                    "Логин",
                    value = loginViewModel.login,
                    onValueChange = { loginViewModel.onLoginChange(it) },
                )
                Spacer(modifier = Modifier.height(10.dp))
                LoginTextField(
                    "Имя или никнейм",
                    value = loginViewModel.name,
                    onValueChange = { loginViewModel.onNameChange(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextButton(onClick = { navController.navigate(Screen.ChangePassword.route) },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)) {
                    Text(text = "Изменить пароль",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(700),
                        color = Primary)
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(
                    vertical = 10.dp,
                    horizontal = 15.dp
                )) {
                Button(onClick = {
                    val currentRoute = navController.currentDestination?.route!!
                    navController.clearBackStack(currentRoute)
                    navController.navigate(Screen.Welcome.route)
                                 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(
                            height = 48.dp,
                            width = 379.dp
                        ),
                    shape = ShapeDefaults.ExtraSmall,
                    colors = ButtonColors(
                        containerColor = Color.Red,
                        contentColor = White,
                        disabledContainerColor = Gray,
                        disabledContentColor = Gray
                    )
                ) { Text("Выйти") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProfileScreen(
                navController = rememberNavController(),
                loginViewModel = LoginViewModel()
            )
        }
    }
}