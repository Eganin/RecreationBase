package com.example.recreationbase.presentaion.mainpage.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.recreationbase.presentaion.ui.theme.AppTheme

@Composable
fun LoaderAndError(collectionIsEmpty : Boolean, error: String?=null) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (collectionIsEmpty) {
            CircularProgressIndicator(color = AppTheme.colors.tintColor)
        } else if (error != null) {
            Text(
                text = error,
                color = AppTheme.colors.errorColor
            )
        }
    }
}