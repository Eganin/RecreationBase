package com.example.recreationbase.presentaion

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography
import retrofit2.http.Header

@Composable
fun Header(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 16.dp, bottom = 16.dp),
        style = Typography.h5.copy(
            color = AppTheme.colors.primaryText,
            fontWeight = FontWeight.Bold
        )
    )
}