package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.navigation.Screen
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.mipmap.ic_bicycles),
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .size(
                    width = 379.dp,
                    height = 335.dp
                ),
            contentDescription = "Main picture",
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(35.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.welcome_screen_title),
                fontSize = 24.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .size(
                        height = 70.dp,
                        width = 379.dp
                    )
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.width(190.dp)
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.welcome_screen_subtitle),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .size(
                        height = 24.dp,
                        width = 334.dp
                    ),
                color = Gray
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = { navController.navigate(route = Screen.Registration.route) },
            modifier = Modifier
                .size(
                    width = 218.dp,
                    height = 48.dp
                ),
            shape = ShapeDefaults.ExtraSmall,
            colors = ButtonColors(
                containerColor = Primary,
                contentColor = White,
                disabledContainerColor = Gray,
                disabledContentColor = Gray
            )
        ) {
            Text(
                text = stringResource(R.string.registation_button_text),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .size(
                        height = 24.dp,
                        width = 170.dp
                    )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = { navController.navigate(route = Screen.Login.route) }
        ) {
            Text(
                text = stringResource(R.string.have_account_already),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .size(
                        height = 24.dp,
                        width = 152.dp
                    ),
                color = Primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            WelcomeScreen(
                navController = rememberNavController()
            )
        }
    }
}