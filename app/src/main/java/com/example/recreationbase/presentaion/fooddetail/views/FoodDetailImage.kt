package com.example.recreationbase.presentaion.fooddetail.views

import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.data.remote.dto.fooddetail.FoodDetailImagesDto
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.squareup.picasso.Picasso

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FoodDetailImage(images: List<FoodDetailImagesDto>) {

    val screenWidth= LocalConfiguration.current.screenWidthDp.dp

    val pagerState = rememberPagerState(initialPage = 0)
    HorizontalPager(
        count = images.size,
        state = pagerState,
        modifier = Modifier.width(screenWidth).height(350.dp)
    ) { page ->
        val imageLink =images[page].orig
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context).inflate(R.layout.image_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo_blog_detail)
                Picasso.get().load(imageLink).into(imageView)
                view
            },
            modifier = Modifier.width(screenWidth),
            update = { view ->
                // Update the view
                val imageView = view.findViewById<ImageView>(R.id.photo_blog_detail)
                Picasso.get().load(imageLink).into(imageView)
            }
        )
    }
}