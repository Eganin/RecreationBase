package com.example.recreationbase.presentaion

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
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography

@Composable
fun ActionButton(openingText: String, closingText: String, onClick: () -> Unit) {

    var isClosingAction by remember { mutableStateOf(false) }
    OutlinedButton(
        onClick = {
            isClosingAction = !isClosingAction
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        shape = CircleShape.copy(all = CornerSize(15.dp)),
        border = BorderStroke(1.dp, AppTheme.colors.tintColor),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.secondaryBackground.copy(
                alpha = 0.1f
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