package com.example.recreationbase.presentaion.blogdetail.views

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.AppTheme
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
            modifier = Modifier.fillMaxSize(),
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
                contentDescription = "content description",
                tint = AppTheme.colors.secondaryText
            )
        }
    }
}