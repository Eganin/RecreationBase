package com.example.recreationbase.presentaion.blogs

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.recreationbase.R
import com.example.recreationbase.domain.model.BlogData
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.Typography
import com.squareup.picasso.Picasso

@Composable
fun BlogCell(data: BlogData) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AndroidView(
            factory = { context ->
                val view = LayoutInflater.from(context).inflate(R.layout.blog_layout, null, false)
                val imageView = view.findViewById<ImageView>(R.id.photo)
                Picasso.get().load(data.image?.lg).into(imageView)
                view
            },
            modifier = Modifier
                .size(328.dp)
                .padding(16.dp)
        )
        data.date?.let {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                style = Typography.body1.copy(color = AppTheme.colors.secondaryText)
            )
        }

        data.title?.let {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, start = 16.dp, end = 16.dp),
                style = Typography.body1.copy(
                    color = AppTheme.colors.primaryText,
                    fontWeight = FontWeight.Bold
                )
            )

        }
    }
}