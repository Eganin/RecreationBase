package com.example.recreationbase.presentaion.fooddetail.views

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography
import com.example.recreationbase.presentaion.views.ActionButton


@Composable
fun FoodDetailContactsView(phoneNumber: String) {
    var startPhoneActivity by remember { mutableStateOf(false) }
    if (startPhoneActivity) {
        val callIntent = Intent(Intent.ACTION_CALL)
        val arrNumbers = phoneNumber.split(" ")
        var res = ""
        arrNumbers.forEach {
            res+=if(it == "+7") "8" else it
        }

        callIntent.data = Uri.parse("tel:"+res.toLong())

        LocalContext.current.startActivity(callIntent)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.contact_label),
            style = Typography.h5.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = phoneNumber,
            style = Typography.body1.copy(color = AppTheme.colors.primaryText)
        )

        ActionButton(
            openingText = stringResource(R.string.call_phone_label),
            closingText = stringResource(R.string.call_phone_label)
        ) {
            startPhoneActivity = !startPhoneActivity
        }
    }
}