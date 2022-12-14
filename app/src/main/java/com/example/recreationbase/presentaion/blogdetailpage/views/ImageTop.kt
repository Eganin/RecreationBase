package com.example.recreationbase.presentaion.blogdetailpage.views

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.squareup.picasso.Picasso

@Composable
fun ImageTop(linkImage: String, onClick: () -> Unit) {
    Box {
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context).inflate(R.layout.image_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo_blog_detail)
                Picasso.get().load(linkImage).into(imageView)
                view
            },
            modifier = Modifier.fillMaxWidth().height(304.dp),
            update = { view ->
                // Update the view
                val imageView = view.findViewById<ImageView>(R.id.photo_blog_detail)
                Picasso.get().load(linkImage).into(imageView)
            }
        )
        OutlinedButton(
            onClick = { onClick() },
            modifier = Modifier
                .size(100.dp)
                .padding(top = 44.dp, start = 20.dp),
            shape = CircleShape,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = stringResource(R.string.arrow_bacl_icon_description),
                tint = AppTheme.colors.secondaryText
            )
        }
    }
}