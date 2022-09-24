package com.example.recreationbase.presentaion.mainpage.tours

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
fun ToursView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadTours)
    }

    val state = viewModel.tourState

    WrapperForRow(
        collectionItems = state.tours,
        headerText = stringResource(R.string.tours_label)
    ) { index ->
        val tourInfo = state.tours[index]
        TourCell(tourData = tourInfo)
    }

    LoaderAndError(collectionIsEmpty = state.tours.isEmpty(), error = state.error)
}