package com.example.recreationbase.presentaion.blogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.Event
import com.example.recreationbase.presentaion.MainViewModel

@Composable
fun BlogView(viewModel : MainViewModel,navController: NavController) {

    LaunchedEffect(key1 = Unit){
        viewModel.onEvent(event = Event.LoadBlogs)
    }

    val state = viewModel.state

    LazyRow(modifier = Modifier.fillMaxWidth()){
        state.info.forEach {data->
            item {
                BlogCell(data = data)
            }
        }
    }
}
