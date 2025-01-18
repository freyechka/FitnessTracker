package com.example.fitnesstracker.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitnesstracker.model.Activity
import com.example.fitnesstracker.model.ActivityListItem
import com.example.fitnesstracker.ui.theme.FitnessTrackerTheme
import com.example.fitnesstracker.ui.widgets.ActivityItem
import com.example.fitnesstracker.ui.widgets.DateHeader
import com.example.fitnesstracker.ui.widgets.PlaceholderWidget
import com.example.fitnesstracker.viewmodel.ActivitiesViewModel
import com.example.fitnesstracker.viewmodel.TabsViewModel


@Composable
fun MyActivityScreen(
    activitiesViewModel: ActivitiesViewModel,
    onActivityClick: (Activity) -> Unit,
    tabsViewModel: TabsViewModel
) {
    val activities by activitiesViewModel.listMyActivities.collectAsState()
    if (activities.isEmpty()) {
        PlaceholderWidget()
    }
    else{
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(activities) { item ->
                when (item) {
                    is ActivityListItem.DataHeader -> DateHeader(item.date)
                    is ActivityListItem.ActivityItem -> ActivityItem(item.activity, onActivityClick, tabsViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyActivityScreen() {
    FitnessTrackerTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            MyActivityScreen(activitiesViewModel = viewModel(), {}, viewModel())
        }
    }
}
