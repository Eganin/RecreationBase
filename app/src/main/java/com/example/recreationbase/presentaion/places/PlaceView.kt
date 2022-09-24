package com.example.recreationbase.presentaion.places

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
fun PlaceView(viewModel: MainViewModel,navController: NavController) {
    LaunchedEffect(key1 = Unit){
        viewModel.onEvent(event = Event.LoadPlaces)
    }

    val state = viewModel.state
    var changeSizeRepeat by remember { mutableStateOf(false) }


    Column {
        Header(text = stringResource(R.string.places_label),additionalActionButton = true){
            changeSizeRepeat = !changeSizeRepeat
        }
        LazyRow(modifier = Modifier.fillMaxWidth()){
            val repeatCount = if (changeSizeRepeat) {
                state.places.size
            } else {
                state.places.size / 2
            }
            repeat(repeatCount){index ->
                val placeInfo = state.places[index]
                item {
                    PlaceCell(placeData = placeInfo)
                }
            }
        }
    }
}