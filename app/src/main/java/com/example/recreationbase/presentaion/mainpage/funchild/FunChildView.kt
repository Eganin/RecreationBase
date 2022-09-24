package com.example.recreationbase.presentaion.mainpage.funchild

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.WrapperForColumn
import com.example.recreationbase.presentaion.mainpage.views.DataVerticalCell
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError

@Composable
fun FunChildView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFunChild)
    }

    val state = viewModel.funChildState

    WrapperForColumn(collectionItems = state.childFun){index->
        val childFunInfo = state.childFun[index]
        DataVerticalCell(
            imageLink = childFunInfo.image?.lg,
            title = childFunInfo.title ?: "",
            subtitle = childFunInfo.subtitle ?: "",
        )
    }

    LoaderAndError(collectionIsEmpty = state.childFun.isEmpty(), error = state.error)
}