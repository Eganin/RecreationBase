package com.example.recreationbase.presentaion.mainpage.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.views.ActionButton
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun <T> WrapperForColumn(
    collectionItems: List<T>,
    isFoodView: Boolean = false,
    content: @Composable (Int) -> Unit
) {
    var changeSizeRepeat by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        FlowColumn {
            val repeatCount = if (changeSizeRepeat) {
                collectionItems.size
            } else {
                collectionItems.size / 2
            }
            repeat(repeatCount) { index ->
                if (isFoodView) {
                    if (index % 2 == 0) {
                        content(index)
                    }
                } else {
                    content(index)
                }
            }
        }
        ActionButton(
            openingText = stringResource(R.string.show_all_label) + " (${collectionItems.size})",
            closingText = stringResource(R.string.closing_text_label)
        ) {
            changeSizeRepeat = !changeSizeRepeat
        }
    }
}