package com.example.recreationbase.presentaion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.blogs.BlogView
import com.example.recreationbase.ui.theme.AppTheme

@Composable
fun MainPage(viewModel : MainViewModel, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(AppTheme.colors.primaryBackground)
    ){
        item {
            BlogView(viewModel = viewModel, navController = navController)
        }
    }
}