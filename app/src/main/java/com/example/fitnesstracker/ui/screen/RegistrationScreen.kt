package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.widgets.BigButton
import com.example.fitnesstracker.ui.widgets.LoginTextField
import com.example.fitnesstracker.ui.widgets.PasswordTextField
import com.example.fitnesstracker.ui.widgets.TopAppBarWidget
import com.example.fitnesstracker.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarWidget(
                navController = navController,
                title = stringResource(R.string.registration_screen_title),
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
                    stringResource(R.string.login_text_field_title),
                    value = loginViewModel.login,
                    onValueChange = { loginViewModel.onLoginChange(it) },
                )
                Spacer(modifier = Modifier.height(5.dp))
                LoginTextField(
                    stringResource(R.string.name_text_field_title),
                    value = loginViewModel.name,
                    onValueChange = { loginViewModel.onNameChange(it) },
                )
                Spacer(modifier = Modifier.height(5.dp))
                PasswordTextField(
                    stringResource(R.string.password_text_field_title),
                    value = loginViewModel.password,
                    onValueChange = { loginViewModel.onPasswordChange(it) }
                )
                Spacer(modifier = Modifier.height(5.dp))
                PasswordTextField(
                    stringResource(R.string.repassword_text_field_title),
                    value = loginViewModel.repassword,
                    onValueChange = { loginViewModel.onRepasswordChange(it) }
                )
                Spacer(modifier = Modifier.height(25.dp))
                SexRadioButton()
                Spacer(modifier = Modifier.height(25.dp))
                BigButton(stringResource(R.string.registation_button_text), {})
                Spacer(modifier = Modifier.height(25.dp))
                DescriptionString()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            RegistrationScreen(
                navController = rememberNavController(),
                loginViewModel = LoginViewModel()
            )
        }
    }
}

@Composable
private fun SexRadioButton() {
    val sexes = listOf(stringResource(R.string.male_sex_option), stringResource(R.string.female_sex_option), stringResource(R.string.other_sex_option))
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(sexes[0])}
    Column(
        modifier = Modifier.padding(
            horizontal = 5.dp)
    ) { Text(
        text = stringResource(R.string.sex_radio_button),
        fontWeight = FontWeight(600),
        fontSize = 20.sp,
        modifier = Modifier.padding(horizontal = 12.dp)
    )
    Column(Modifier.selectableGroup()) {
        sexes.forEach { text ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonColors(
                        selectedColor = Primary,
                        unselectedColor = Primary,
                        disabledSelectedColor = Gray,
                        disabledUnselectedColor = Gray
                    )
                )
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
    }
}

@Composable
private fun DescriptionString() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 15.dp)) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight(400),
            text = getDescriptionString(),
            style = TextStyle.Default.copy(
                lineBreak = LineBreak.Paragraph.copy(
                strategy = LineBreak.Strategy.Balanced)
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun getDescriptionString(): AnnotatedString {
    return buildAnnotatedString {

        append(stringResource(R.string.registration_screen_description_1))
        withLink(
            LinkAnnotation.Url(
                "https://developer.android.com/jetpack/compose",
                TextLinkStyles(
                    style = SpanStyle(color = Primary)
                )
            )
        )
        {
            append(stringResource(R.string.registration_screen_description_2))
        }
        append(stringResource(R.string.registration_screen_description_3))
        withLink(
            LinkAnnotation.Url(
                "https://developer.android.com/jetpack/compose",
                TextLinkStyles(
                    style = SpanStyle(color = Primary)
                )
            )
        )
        {
            append(stringResource(R.string.registration_screen_description_4))
        }
    }
}