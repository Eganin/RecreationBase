package com.example.recreationbase.presentaion.fooddetail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@Composable
fun FoodDetailTitle(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.nutrition_label),
            style = Typography.overline.copy(color = AppTheme.colors.secondaryText)
        )
        Text(
            text = title,
            style = Typography.h5.copy(color = AppTheme.colors.primaryText, fontWeight = FontWeight.Bold)
        )
        Text(
            text = subtitle,
            style = Typography.body1.copy(color = AppTheme.colors.primaryText)
        )
    }
}