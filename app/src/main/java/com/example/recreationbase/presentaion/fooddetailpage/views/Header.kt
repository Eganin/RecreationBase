package com.example.recreationbase.presentaion.fooddetailpage.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@Composable
fun Header(title: String, navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = stringResource(R.string.arrow_bacl_icon_description),
            tint = AppTheme.colors.secondaryText,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Text(
            text = title,
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )

    }
}