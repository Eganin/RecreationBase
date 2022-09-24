package com.example.recreationbase.presentaion.rooms

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ActionButton
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.views.DataVerticalCell
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun RoomsView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadRooms)
    }

    val state = viewModel.state
    var changeSizeRepeat by remember { mutableStateOf(false) }

    Column {
        FlowColumn {
            val repeatCount = if (changeSizeRepeat) {
                state.rooms.size
            } else {
                state.rooms.size / 2
            }
            repeat(repeatCount) { index ->
                val roomInfo = state.rooms[index]
                DataVerticalCell(
                    imageLink = roomInfo.image?.lg,
                    title = "До ${roomInfo.countTourist} гостей",
                    subtitle = roomInfo.title ?: "",
                    price = roomInfo.price + roomInfo.currencyPrice,
                    discount = roomInfo.discount
                )
            }
        }
        ActionButton(
            openingText = stringResource(R.string.show_all_label) + " (${state.rooms.size})",
            closingText = stringResource(R.string.closing_text_label)
        ) {
            changeSizeRepeat = !changeSizeRepeat
        }
    }
}