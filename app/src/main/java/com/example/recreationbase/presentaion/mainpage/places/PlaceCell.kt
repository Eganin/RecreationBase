package com.example.recreationbase.presentaion.mainpage.places

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.recreationbase.data.remote.dto.places.PlaceDataDto
import com.example.recreationbase.presentaion.mainpage.views.DataVerticalCell
import com.example.recreationbase.presentaion.ui.theme.AppTheme

@Composable
fun PlaceCell(placeData: PlaceDataDto) {
    Card(
        elevation = 20.dp,
        modifier = Modifier
            .width(304.dp)
            .height(96.dp)
            .padding(start = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(10.dp))

    ) {
        DataVerticalCell(
            imageLink = placeData.image?.lg,
            title = placeData.title ?: "",
            subtitle = placeData.subtitle ?: "",
            modifier = Modifier
                .size(80.dp)
                .background(AppTheme.colors.cardBackground)
        )
    }
}