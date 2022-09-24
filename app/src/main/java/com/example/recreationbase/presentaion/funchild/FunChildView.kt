package com.example.recreationbase.presentaion.funchild

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
fun FunChildView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFunChild)
    }

    val state = viewModel.state
    var changeSizeRepeat by remember { mutableStateOf(false) }

    Column {
        FlowColumn {
            val repeatCount = if (changeSizeRepeat) {
                state.childFun.size
            } else {
                state.childFun.size / 2
            }
            repeat(repeatCount) { index ->
                val childFunInfo = state.childFun[index]
                DataVerticalCell(
                    imageLink = childFunInfo.image?.lg,
                    title = childFunInfo.title ?: "",
                    subtitle = childFunInfo.subtitle ?: "",
                )
            }
        }
        ActionButton(
            openingText = stringResource(R.string.show_all_label) + " (${state.childFun.size})",
            closingText = stringResource(R.string.closing_text_label)
        ) {
            changeSizeRepeat = !changeSizeRepeat
        }
    }
}