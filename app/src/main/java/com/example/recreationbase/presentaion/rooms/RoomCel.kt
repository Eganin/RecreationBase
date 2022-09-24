package com.example.recreationbase.presentaion.rooms

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.domain.model.RoomData
import com.example.recreationbase.presentaion.PriceView
import com.example.recreationbase.presentaion.TextViewCells
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Red
import com.example.recreationbase.ui.theme.Typography
import com.squareup.picasso.Picasso

@Composable
fun RoomCell(roomInfo: RoomData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context).inflate(R.layout.image_corner_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(roomInfo.image?.lg).into(imageView)
                view
            },
            modifier = Modifier
                .size(130.dp)
                .padding(16.dp),
            update = { view ->
                // Update the view
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(roomInfo.image?.lg).into(imageView)
            }
        )
        Column(modifier = Modifier.padding(top = 21.dp)) {
            TextViewCells(
                firstLabel = "До ${roomInfo.countTourist} гостей",
                secondLabel = roomInfo.title ?: ""
            )
            Row(modifier = Modifier.padding(top = 4.dp)) {
                PriceView(
                    price = roomInfo.price + roomInfo.currencyPrice,
                    discount = roomInfo.discount
                )
            }
        }
    }
}