package com.example.recreationbase.presentaion.foods

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.ui.theme.AppTheme
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun FoodsView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFoods)
    }

    val state = viewModel.state

    FlowColumn {
        repeat(state.foods.size) { index ->
            if (index % 2 == 0) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    FoodCell(
                        foodInfo = state.foods[index],
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                    FoodCell(
                        foodInfo = state.foods[index + 1],
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    )
                }
            }
        }
    }
}