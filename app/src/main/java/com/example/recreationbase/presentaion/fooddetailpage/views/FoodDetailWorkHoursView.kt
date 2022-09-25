package com.example.recreationbase.presentaion.fooddetailpage.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@Composable
fun FoodDetailWorkHoursView(workingHours: List<Pair<String, String>>, isOpen: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.work_hours_label),
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.is_open_label),
                style = Typography.body1.copy(color = AppTheme.colors.primaryText)
            )
            if (isOpen) {
                Text(
                    text = "Открыто",
                    style = Typography.body1.copy(color = Color.Green)
                )
            } else {
                Text(
                    text = "Закрыто",
                    style = Typography.body1.copy(color = Color.Red)
                )
            }
        }
        workingHours.map { (day, time) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = day,
                    style = Typography.body1.copy(color = AppTheme.colors.primaryText)
                )
                Text(
                    text = time,
                    style = Typography.body1.copy(color = AppTheme.colors.primaryText)
                )
            }
        }
    }
}