package com.example.recreationbase.presentaion.mainpage.places

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError
import com.example.recreationbase.presentaion.mainpage.views.WrapperForRow

@Composable
fun PlaceView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadPlaces)
    }

    val state = viewModel.placeState

    WrapperForRow(
        collectionItems = state.places,
        headerText = stringResource(R.string.places_label)
    ) { index ->
        val placeInfo = state.places[index]
        PlaceCell(placeData = placeInfo)
    }

    LoaderAndError(collectionIsEmpty = state.places.isEmpty(), error = state.error)
}