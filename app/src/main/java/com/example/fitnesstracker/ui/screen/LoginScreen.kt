package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.navigation.Screen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.widgets.BigButton
import com.example.fitnesstracker.ui.widgets.LoginTextField
import com.example.fitnesstracker.ui.widgets.PasswordTextField
import com.example.fitnesstracker.ui.widgets.TopAppBarWidget
import com.example.fitnesstracker.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarWidget(
                navController = navController,
                title = stringResource(R.string.login_screen_title),
                actions = {}
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.mipmap.ic_bicycles),
                    modifier = Modifier
                        .padding(horizontal = 70.dp)
                        .size(
                            width = 272.dp,
                            height = 240.dp
                        ),
                    contentDescription = "Main picture",
                    contentScale = ContentScale.Fit
                )
                LoginTextField(
                    stringResource(R.string.login_text_field_title),
                    value = loginViewModel.login,
                    onValueChange = { loginViewModel.onLoginChange(it) },
                )
                Spacer(modifier = Modifier.height(5.dp))
                PasswordTextField(
                    stringResource(R.string.password_text_field_title),
                    value = loginViewModel.password,
                    onValueChange = { loginViewModel.onPasswordChange(it) },
                )
                Spacer(modifier = Modifier.height(30.dp))
                BigButton(stringResource(R.string.login_button_text), onClick = { navController.navigate(Screen.Activities.route) })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            LoginScreen(
                navController = rememberNavController(),
                loginViewModel = LoginViewModel()
            )
        }
    }
}

