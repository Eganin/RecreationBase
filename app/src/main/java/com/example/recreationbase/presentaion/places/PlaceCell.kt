package com.example.recreationbase.presentaion.places

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.recreationbase.data.remote.dto.places.PlaceDataDto
import com.example.recreationbase.presentaion.views.DataVerticalCell
import com.example.recreationbase.ui.theme.AppTheme

@Composable
fun PlaceCell(placeData: PlaceDataDto) {
    Card(
        elevation = 5120.dp,
        modifier = Modifier
            .width(304.dp)
            .height(96.dp)
            .padding(start = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(AppTheme.colors.cardBackground)

    ) {
        DataVerticalCell(
            imageLink = placeData.image?.lg,
            title = placeData.title ?: "",
            subtitle = placeData.subtitle ?: "",
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp)
        )
    }
}