package com.example.recreationbase.presentaion.mainpage.blogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.mainpage.Event
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError

@Composable
fun BlogView(viewModel: MainViewModel, navController: NavController) {

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = Event.LoadBlogs)
    }

    val state = viewModel.blogState

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        state.blogs.forEach { data ->
            item {
                BlogCell(data = data) {
                    with(navController) {
                        currentBackStackEntry?.savedStateHandle?.set(
                            key = "ID_KEY",
                            value = data.id
                        )
                        navigate("BlogDetail")
                    }
                }
            }
        }
    }

    LoaderAndError(collectionIsEmpty = state.blogs.isEmpty(), error = state.error)
}
