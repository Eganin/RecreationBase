package com.example.recreationbase.presentaion.mainpage.rooms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.WrapperForColumn
import com.example.recreationbase.presentaion.mainpage.views.DataVerticalCell
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError

@Composable
fun RoomsView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadRooms)
    }

    val state = viewModel.roomState

    WrapperForColumn(collectionItems = state.rooms){index->
        val roomInfo = state.rooms[index]
        DataVerticalCell(
            imageLink = roomInfo.image?.lg,
            title = "До ${roomInfo.countTourist} гостей",
            subtitle = roomInfo.title ?: "",
            price = roomInfo.price + roomInfo.currencyPrice,
            discount = roomInfo.discount
        )
    }

    LoaderAndError(collectionIsEmpty = state.rooms.isEmpty(), error = state.error)

}