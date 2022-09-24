package com.example.recreationbase.presentaion

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.blogs.BlogView
import com.example.recreationbase.presentaion.foods.FoodsView
import com.example.recreationbase.presentaion.funchild.FunChildView
import com.example.recreationbase.presentaion.funs.FunView
import com.example.recreationbase.presentaion.rooms.RoomsView
import com.example.recreationbase.presentaion.tours.ToursView
import com.example.recreationbase.presentaion.views.Header

@Composable
fun MainPage(viewModel: MainViewModel, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 70.dp)
    ) {
        item {
            Header(text = stringResource(R.string.main_label))
        }
        item {
            HeaderInfo()
        }
        item {
            Header(text = stringResource(R.string.food_title))
        }
        item {
            FoodsView(viewModel = viewModel, navController = navController)
        }
        item {
            Header(text = stringResource(R.string.rooms_label))
        }
        item {
            RoomsView(viewModel = viewModel, navController = navController)
        }
        item {
            FunView(viewModel = viewModel, navController = navController)
        }
        item {
            Header(text = stringResource(R.string.fun_for_child_label))
        }
        item {
            FunChildView(viewModel = viewModel, navController = navController)
        }
        item {
            Header(text = stringResource(R.string.blog_title))
        }
        item {
            BlogView(viewModel = viewModel, navController = navController)
        }

        item {
            ToursView(viewModel = viewModel, navController = navController)
        }

    }
}