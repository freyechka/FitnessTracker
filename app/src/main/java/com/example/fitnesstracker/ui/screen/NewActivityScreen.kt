package com.example.fitnesstracker.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstracker.R
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.model.Converter
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.theme.Gray
import com.example.fitnesstracker.ui.theme.Primary
import com.example.fitnesstracker.ui.theme.White
import com.example.fitnesstracker.ui.widgets.BigButton
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewActivityScreen(navController: NavController, activitiesViewModel: ActivitiesViewModel) {
    var start by remember { mutableStateOf(0) }
    var activity = Activity(
        id = 0,
        duration = "end-start",
        start = "after",
        end = "after",
        title = "choose",
        date = LocalDate.now(),
        isMine = true,
        author = "get_author",
        startLatitude = 1.1,
        endLatitude = 2.2,
        startLongitude = 3.3,
        endLongitude = 4.4
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
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
                title = {  },
                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = Color.Transparent,
                    titleContentColor = Color.Transparent,
                    actionIconContentColor = Color.Transparent
                )
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 30.dp)
                    .height(287.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardColors(
                    containerColor = White,
                    contentColor = Color.Black,
                    disabledContentColor = White,
                    disabledContainerColor = Gray
                )
            ) {
                when(start){
                    0 -> BeforeStart(activitiesViewModel)
                    1 -> Started(activity)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewActivityScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            NewActivityScreen(
                navController = rememberNavController(),
                activitiesViewModel = viewModel()
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun BeforeStart(activitiesViewModel: ActivitiesViewModel) {
    var type by mutableStateOf(value = !activitiesViewModel.selected)
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Погнали? :)",
            modifier = Modifier.padding(vertical = 25.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(700)
        )
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                elevation = CardDefaults.cardElevation(6.dp),
                border = BorderStroke(2.dp, if (activitiesViewModel.selected) Primary else Gray),
                colors = CardColors(
                    containerColor = White,
                    contentColor = Color.Black,
                    disabledContentColor = White,
                    disabledContainerColor = Gray
                ),
                onClick = { activitiesViewModel.selected = !activitiesViewModel.selected}
            ) { Row(horizontalArrangement = Arrangement.Center) {
                Text(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 10.dp),
                    text = activitiesViewModel.titles[0],
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                )
                Image(
                    painter = painterResource(R.mipmap.ic_activities),
                    modifier = Modifier
                        .size(
                            width = 102.dp,
                            height = 84.dp
                        ),
                    contentDescription = "Main picture",
                    contentScale = ContentScale.Crop
                )
            }
            }
            Card(
                elevation = CardDefaults.cardElevation(6.dp),
                border = BorderStroke(2.dp, if (!activitiesViewModel.selected) Primary else Gray),
                colors = CardColors(
                    containerColor = White,
                    contentColor = Color.Black,
                    disabledContentColor = White,
                    disabledContainerColor = Gray
                ),
                onClick = { activitiesViewModel.selected = !activitiesViewModel.selected}
            ) { Row(horizontalArrangement = Arrangement.Center)
            {
                Text(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 10.dp),
                    text = activitiesViewModel.titles[1],
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                )
                Image(
                    painter = painterResource(R.mipmap.ic_activities),
                    modifier = Modifier
                        .size(
                            width = 102.dp,
                            height = 84.dp
                        ),
                    contentDescription = "Main picture",
                    contentScale = ContentScale.Crop
                )
            }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        BigButton("Начать", { addActivity(type, activitiesViewModel) })
    }
}

private fun addActivity(type: Boolean, vm:ActivitiesViewModel) {
    val start = Random.nextInt(100, 500)
    val end = Random.nextInt(1000, 2000)
    val duration = end-start
    val day = Random.nextInt(10, 28)
    val month = Random.nextInt(1, 9)
    val startLat = Random.nextDouble(-90.0, 90.0)
    val endLat = Random.nextDouble(-90.0, 90.0)
    val startLon = Random.nextDouble(-180.0, 180.0)
    val endLon = Random.nextDouble(-180.0, 180.0)
    val activity = Activity(
        id = 0,
        duration = duration.toString(),
        start = start.toString(),
        end = end.toString(),
        title = vm.titles[type.toInt()],
        date = LocalDate.parse("$day.0$month.2024", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
        isMine = true,
        author = "@milana",
        startLatitude = startLat,
        endLatitude = endLat,
        startLongitude = startLon,
        endLongitude = endLon
    )
    vm.addActivity(activity)
}

fun Boolean.toInt(): Int = if (this) 1 else 0

fun roundToDecimals(value: Double, decimals: Int): Double {
    val factor = 10.0.pow(decimals)
    return round(value*factor) / factor
}

@Composable
private fun Started(activity: Activity) {
    Box(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()) {
        Column {
            Text(
                text = activity.title,
                modifier = Modifier.padding(vertical = 20.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = calculateDistance(activity.startLatitude, activity.endLatitude, activity.startLongitude, activity.startLongitude).toString() + " км",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = activity.duration,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400)
                )
            }
        }
        Button({},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .size(75.dp),
            shape = CircleShape,
            colors = ButtonColors(
                containerColor = Primary,
                contentColor = White,
                disabledContainerColor = Gray,
                disabledContentColor = Gray
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.racing_flag_1),
                    contentDescription = "Finish",
                    modifier = Modifier.scale(1.5F)
                )
            }
        }
    }
}

fun calculateDistance(
    startLatitude: Double,
    endLatitude: Double,
    startLongitude: Double,
    endLongitude: Double
): Double {
    val earthRadius = 6371.0

    val dLat = Math.toRadians(endLatitude - startLatitude)
    val dLon = Math.toRadians(endLongitude - startLongitude)

    val a = sin(dLat / 2) * sin(dLat / 2) +
            cos(Math.toRadians(startLatitude)) * cos(Math.toRadians(endLatitude)) *
            sin(dLon / 2) * sin(dLon / 2)

    val c = 2 * atan2(sqrt(a), sqrt(1-a))

    return roundToDecimals((earthRadius * c), 2) // in kilometers
}