package com.example.recreationbase.presentaion.fooddetail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.recreationbase.presentaion.views.ActionButton

@Composable
fun FoodDetailAddressView(address: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = stringResource(R.string.address_label),
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = address,
            style = Typography.body1.copy(color = AppTheme.colors.primaryText)
        )
        ActionButton(
            openingText = stringResource(R.string.show_map_label),
            closingText = stringResource(R.string.show_map_label)
        ) {}
        ActionButton(
            openingText = stringResource(R.string.route_path_label),
            closingText = stringResource(R.string.route_path_label)
        ) {}
    }
}