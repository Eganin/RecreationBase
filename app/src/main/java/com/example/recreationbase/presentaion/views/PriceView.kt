package com.example.recreationbase.presentaion

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Red
import com.example.recreationbase.ui.theme.Typography

@Composable
fun PriceView(price: String, discount: String? = null,isRoomData : Boolean=true) {
    if (discount == null) {
        Text(
            text = price,
            style = Typography.body1.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            )
        )
        if(isRoomData){
            Text(
                text = stringResource(R.string.night_price_label),
                style = Typography.body1.copy(
                    color = AppTheme.colors.primaryText,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    } else {
        Text(
            text = price, style = Typography.body1.copy(
                color = AppTheme.colors.secondaryText.copy(alpha = 0.4f),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.LineThrough
            )
        )
        Text(
            text = discount,
            style = Typography.body1.copy(
                color = Red,
            ),
            modifier = Modifier.padding(start = 4.dp)
        )
        Text(
            text = stringResource(R.string.night_price_label),
            style = Typography.body1.copy(
                color = Red
            ),
            modifier = Modifier.padding(start = 2.dp)
        )
    }
}