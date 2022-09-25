package com.example.recreationbase.presentaion.fooddetailpage.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recreationbase.data.remote.dto.fooddetail.FoodDetailImagesDto
import com.example.recreationbase.presentaion.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FoodDetailImage(images: List<FoodDetailImagesDto>) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val pagerState = rememberPagerState(initialPage = 0)
    HorizontalPager(
        count = images.size,
        state = pagerState,
        modifier = Modifier
            .width(screenWidth)
            .height(350.dp)
    ) { page ->
        val imageLink = images[page].orig
        Box(
            modifier = Modifier
                .width(screenWidth)
                .height(350.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            AsyncImage(
                model = imageLink,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(screenWidth)
                    .height(350.dp)
            )
            if (images.size > 1) {
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp),
                    shape = CircleShape.copy(all = CornerSize(15.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(
                        text = "${page + 1}/${images.size}",
                        style = Typography.overline.copy(color = Color.White),
                    )
                }
            }
        }
    }
}