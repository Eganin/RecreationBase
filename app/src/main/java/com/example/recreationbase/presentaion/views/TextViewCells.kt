package com.example.recreationbase.presentaion.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography

@Composable
fun TextViewCells(firstLabel: String, secondLabel: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = firstLabel,
            style = Typography.body2.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.width(220.dp)
        )
        Text(
            text = secondLabel,
            style = Typography.body1.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.width(220.dp)
        )
    }
}