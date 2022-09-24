package com.example.recreationbase.presentaion.foods

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ActionButton
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.views.DataHorizontalCell
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
            val repeatCount = if (changeSizeRepeat) {
                state.foods.size
            } else {
                state.foods.size / 2
            }
            repeat(repeatCount) { index ->
                if (index % 2 == 0) {
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
            }
        }
        ActionButton(
            openingText = stringResource(R.string.show_all_label) + " (${state.foods.size})",
            closingText = stringResource(R.string.closing_text_label)
        ) {
            changeSizeRepeat = !changeSizeRepeat
        }

    }
}