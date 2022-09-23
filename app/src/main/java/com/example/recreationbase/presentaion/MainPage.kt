package com.example.recreationbase.presentaion

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.blogs.BlogView

@Composable
fun MainPage(viewModel : MainViewModel, navController: NavController) {
    viewModel.onEvent(event = Event.LoadFoods)
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ){
        item {
            Header(text = stringResource(R.string.food_title))
        }
        item {
            Header(text = stringResource(R.string.blog_title))
        }
        item {
            BlogView(viewModel = viewModel, navController = navController)
        }

    }
}