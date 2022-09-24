package com.example.recreationbase.presentaion.mainpage.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun <T> WrapperForRow(
    collectionItems: List<T>,
    headerText: String,
    content: @Composable (Int) -> Unit
) {

    var changeSizeRepeat by remember { mutableStateOf(false) }

    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Header(text = headerText, additionalActionButton = true) {
            changeSizeRepeat = !changeSizeRepeat
        }

        LazyRow(modifier = Modifier.fillMaxWidth(), state = scrollState) {
            val repeatCount = if (changeSizeRepeat) {
                coroutineScope.launch {
                    scrollState.scrollToItem(collectionItems.size - 1)
                }
                collectionItems.size
            } else {
                coroutineScope.launch {
                    scrollState.scrollToItem(0)
                }
                collectionItems.size / 2
            }
            repeat(repeatCount) { index ->
                item {
                    content(index)
                }
            }
        }
    }
}