package com.example.recreationbase.presentaion.tours

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.domain.model.TourData
import com.example.recreationbase.presentaion.PriceView
import com.example.recreationbase.presentaion.views.TextViewCells
import com.example.recreationbase.ui.theme.AppTheme
import com.squareup.picasso.Picasso

@Composable
fun TourCell(tourData: TourData) {
    Card(
        elevation = 20.dp,
        modifier = Modifier
            .size(302.dp)
            .padding(start = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(10.dp))

    ) {
        Column(modifier = Modifier.background(AppTheme.colors.cardBackground)) {
            AndroidView(
                factory = { context ->
                    val view =
                        LayoutInflater.from(context)
                            .inflate(R.layout.image_corner_layout, null, false)
                    val imageView = view.findViewById<ImageView>(R.id.photo)
                    Picasso.get().load(tourData.image?.lg).into(imageView)
                    view
                },
                modifier = Modifier
                    .width(302.dp)
                    .height(200.dp),
                update = { view ->
                    // Update the view
                    val imageView = view.findViewById<ImageView>(R.id.photo)
                    Picasso.get().load(tourData.image?.lg).into(imageView)
                }
            )
            TextViewCells(
                firstLabel = tourData.title ?: "",
                secondLabel = tourData.location ?: "",
            )
            PriceView(
                price = tourData.price.toString()+tourData.currency,
                isRoomData = false
            )
        }
    }
}