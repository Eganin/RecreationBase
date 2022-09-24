package com.example.recreationbase.presentaion

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography

@Composable
fun TextViewCells(firstLabel: String, secondLabel: String) {
    Column {
        Text(
            text = firstLabel,
            style = Typography.body2.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = secondLabel,
            style = Typography.body1.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            overflow = TextOverflow.Ellipsis
        )
    }
}