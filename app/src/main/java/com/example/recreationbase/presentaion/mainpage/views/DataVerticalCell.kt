package com.example.recreationbase.presentaion.mainpage.views

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.squareup.picasso.Picasso

@Composable
fun DataVerticalCell(
    imageLink: String?,
    title: String,
    subtitle: String,
    price: String? = null,
    discount: String? = null,
    modifier: Modifier? = null,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context).inflate(R.layout.image_corner_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(imageLink).into(imageView)
                view
            },
            modifier = modifier?.padding(16.dp) ?: Modifier
                .size(130.dp)
                .padding(16.dp),
            update = { view ->
                // Update the view
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(imageLink).into(imageView)
            }
        )
        Column(modifier = Modifier.padding(top = 21.dp)) {
            TextViewCells(
                firstLabel = title,
                secondLabel = subtitle
            )
            Row(modifier = Modifier.padding(top = 4.dp)) {
                if (price != null) {
                    if (discount == null) {
                        PriceView(
                            price = price,
                        )
                    } else {
                        PriceView(
                            price = price,
                            discount = discount
                        )
                    }
                }
            }
        }
    }
}