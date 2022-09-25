package com.example.recreationbase.presentaion.blogdetailpage.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@Composable
fun DetailBlogTitle(date: String, subtitle: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = date,
            style = Typography.overline.copy(color = AppTheme.colors.secondaryText),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = subtitle,
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}