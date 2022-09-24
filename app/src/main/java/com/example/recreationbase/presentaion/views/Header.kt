package com.example.recreationbase.presentaion.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography

@Composable
fun Header(
    text: String,
    additionalActionButton: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    var isClosingAction by remember { mutableStateOf(false) }
    val openingText = stringResource(R.string.open_all_label)
    val closingText = stringResource(R.string.close_label)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 50.dp, start = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = text,
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            )
        )
        if (additionalActionButton) {
            Text(
                text = if (isClosingAction) closingText else openingText,
                style = Typography.body1.copy(
                    color = AppTheme.colors.tintColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(start = 100.dp, end = 10.dp)
                    .clickable {
                        isClosingAction = !isClosingAction
                        onClick?.invoke()
                    }
            )
        }
    }
}