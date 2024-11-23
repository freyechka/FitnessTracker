package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lint.kotlin.metadata.Visibility
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.PurpleGrey40
import com.example.fitnesstracker.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.login_screen_title),
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
                }

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
                LoginTextField(stringResource(R.string.login_text_field_title))
                Spacer(modifier = Modifier.height(5.dp))
                PasswordTextField(stringResource(R.string.password_text_field_title))
                Spacer(modifier = Modifier.height(30.dp))
                BigButton(stringResource(R.string.login_button_text))
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
                navController = rememberNavController()
            )
        }
    }
}

@Composable
fun LoginTextField(text: String) {
    val login = remember { mutableStateOf("") }
    OutlinedTextField(
        login.value,
        {login.value = it},
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        label = { Text(
            text = text,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            color = Gray) }
    )
}

@Composable
fun PasswordTextField(text: String) {
    val password = remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = text,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                color = Gray
            )
        },
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    imageVector = if (showPassword) {
                        Icons.Filled.VisibilityOff
                    } else {
                        Icons.Filled.Visibility
                    },
                    contentDescription = if (showPassword) "Hide password" else "Show password"
                )
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

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