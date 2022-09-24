package com.example.recreationbase.presentaion.mainpage.funs

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.DataHorizontalCell
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError
import com.example.recreationbase.presentaion.mainpage.views.WrapperForRow

@Composable
fun FunView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFun)
    }

    val state = viewModel.funState

    WrapperForRow(
        collectionItems = state.funs,
        headerText = stringResource(R.string.fun_label)
    ) { index ->
        val funInfo = state.funs[index]
        DataHorizontalCell(
            imageLink = funInfo.image?.lg,
            title = funInfo.title ?: "",
            subtitle = funInfo.subtitle ?: "",
            modifier = Modifier.padding(start = 16.dp)
        )
    }

    LoaderAndError(collectionIsEmpty = state.funs.isEmpty(), error = state.error)

}