package com.example.recreationbase.presentaion.foods

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.ShowAllItemsButton
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun FoodsView(viewModel: MainViewModel, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadFoods)
    }

    val state = viewModel.state

    var changeSizeRepeat by remember { mutableStateOf(false) }
    Column {
        FlowColumn {
            val repeatCount = if(changeSizeRepeat){
                state.foods.size
            }else{
                state.foods.size/2
            }
            repeat(repeatCount) { index ->
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
        ShowAllItemsButton(sizeItems = state.foods.size) {
            changeSizeRepeat=!changeSizeRepeat
        }
    }
}