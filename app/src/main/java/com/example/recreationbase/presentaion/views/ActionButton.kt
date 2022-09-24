package com.example.recreationbase.presentaion.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@Composable
fun ActionButton(openingText: String, closingText: String, onClick: () -> Unit) {

    var isClosingAction by remember { mutableStateOf(false) }
    OutlinedButton(
        onClick = {
            isClosingAction = !isClosingAction
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth(),
        shape = CircleShape.copy(all = CornerSize(15.dp)),
        border = BorderStroke(1.dp, AppTheme.colors.tintColor),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.secondaryBackground.copy(
                alpha = 0.2f
            )
        )
    ) {
        Text(
            text = if (isClosingAction) closingText else openingText,
            style = Typography.body1.copy(
                color = AppTheme.colors.tintColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}