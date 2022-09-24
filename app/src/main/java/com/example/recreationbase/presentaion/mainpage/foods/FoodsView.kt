package com.example.recreationbase.presentaion.mainpage.foods

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.WrapperForColumn
import com.example.recreationbase.presentaion.mainpage.views.DataHorizontalCell
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError
import com.example.recreationbase.presentaion.ui.theme.AppTheme

@Composable
fun FoodsView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFoods)
    }

    val state = viewModel.foodState

    WrapperForColumn(collectionItems = state.foods, isFoodView = true) { index ->
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            val foodInfo = state.foods[index]
            val nextFoodInfo = state.foods[index + 1]
            DataHorizontalCell(
                imageLink = foodInfo.image?.lg,
                title = foodInfo.title ?: "",
                subtitle = foodInfo.subtitle ?: "",
                modifier = Modifier.padding(start = 16.dp)
            )
            DataHorizontalCell(
                imageLink = nextFoodInfo.image?.lg,
                title = nextFoodInfo.title ?: "",
                subtitle = nextFoodInfo.subtitle ?: "",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }

    LoaderAndError(collectionIsEmpty = state.foods.isEmpty(), error = state.error)

}