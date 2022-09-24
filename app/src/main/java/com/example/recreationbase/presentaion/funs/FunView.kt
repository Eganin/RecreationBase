package com.example.recreationbase.presentaion.funs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.views.DataHorizontalCell
import com.example.recreationbase.presentaion.views.Header

@Composable
fun FunView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFun)
    }

    val state = viewModel.state
    var changeSizeRepeat by remember { mutableStateOf(false) }

    Column {
        Header(text = stringResource(R.string.fun_label),additionalActionButton = true){
            changeSizeRepeat = !changeSizeRepeat
        }
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            val repeatCount = if (changeSizeRepeat) {
                state.funs.size
            } else {
                state.funs.size / 2
            }
            repeat(repeatCount){index->
                val funInfo = state.funs[index]
                item{
                    DataHorizontalCell(
                        imageLink = funInfo.image?.lg,
                        title = funInfo.title ?: "",
                        subtitle = funInfo.subtitle ?: "",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}