package com.example.recreationbase.presentaion

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography

@Composable
fun ShowAllItemsButton(sizeItems: Int, onClick: () -> Unit) {

    OutlinedButton(
        onClick = { onClick() },
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
            text = stringResource(R.string.show_all_label)+" ($sizeItems)",
            style = Typography.body1.copy(
                color = AppTheme.colors.tintColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}