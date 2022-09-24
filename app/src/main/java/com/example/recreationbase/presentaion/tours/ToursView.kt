package com.example.recreationbase.presentaion.tours

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.views.Header

@Composable
fun ToursView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadTours)
    }

    val state = viewModel.state
    var changeSizeRepeat by remember { mutableStateOf(false) }

    Column {
        Header(text = stringResource(R.string.tours_label), additionalActionButton = true) {
            changeSizeRepeat = !changeSizeRepeat
        }

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            val repeatCount = if (changeSizeRepeat) {
                state.tours.size
            } else {
                state.tours.size / 2
            }
            repeat(repeatCount){index->
                val tourInfo = state.tours[index]
                item {
                    TourCell(tourData = tourInfo)
                }
            }
        }
    }
}