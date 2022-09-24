package com.example.recreationbase.presentaion.fooddetail

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController

@Composable
fun FoodDetailPage(viewModel: FoodDetailViewModel, id: Int, navController: NavController) {
    LaunchedEffect(key1 = Unit){
        viewModel.onEvent(event = FoodDetailEvent.LoadInfo(id=id))
    }

    val state = viewModel.state
}