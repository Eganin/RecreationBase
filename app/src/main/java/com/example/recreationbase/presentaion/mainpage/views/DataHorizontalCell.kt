package com.example.recreationbase.presentaion.mainpage.views

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography
import com.squareup.picasso.Picasso

@Composable
fun DataHorizontalCell(imageLink: String?, title: String, subtitle: String,modifier: Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = (configuration.screenWidthDp.dp / 2) - 20.dp
    Column {
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context)
                        .inflate(R.layout.image_corner_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(imageLink).into(imageView)
                view
            },
            modifier = modifier
                .width(screenWidth)
                .height(100.dp),
            update = { view ->
                // Update the view
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(imageLink).into(imageView)
            }
        )
        Text(
            text = title,
            modifier = modifier.width(screenWidth),
            style = Typography.body1.copy(
                color = AppTheme.colors.primaryText,
                fontWeight = FontWeight.Bold
            ),
            maxLines = 1
        )
        Text(
            text = subtitle,
            modifier =modifier.width(screenWidth),
            style = Typography.body1.copy(color = AppTheme.colors.secondaryText),
            maxLines = 2
        )
    }
}