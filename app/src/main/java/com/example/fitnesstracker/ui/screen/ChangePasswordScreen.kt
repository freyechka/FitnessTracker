package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.widgets.BigButton
import com.example.fitnesstracker.ui.widgets.LoginTextField
import com.example.fitnesstracker.ui.widgets.TopAppBarWidget
import com.example.fitnesstracker.viewmodel.LoginViewModel

@Composable
fun ChangePasswordScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarWidget(
                navController = navController,
                title = "Изменить пароль",
                actions = {}
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
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
                    "Старый пароль",
                    value = loginViewModel.login,
                    onValueChange = { loginViewModel.onLoginChange(it) },
                )
                Spacer(modifier = Modifier.height(20.dp))
                LoginTextField(
                    "Новый пароль",
                    value = loginViewModel.password,
                    onValueChange = { loginViewModel.onPasswordChange(it) }
                )
                Spacer(modifier = Modifier.height(5.dp))
                LoginTextField(
                    "Повторите пароль",
                    value = loginViewModel.repassword,
                    onValueChange = { loginViewModel.onRepasswordChange(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                BigButton("Принять", {})
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChangePasswordScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ChangePasswordScreen(
                navController = rememberNavController(),
                loginViewModel = LoginViewModel()
            )
        }
    }
}