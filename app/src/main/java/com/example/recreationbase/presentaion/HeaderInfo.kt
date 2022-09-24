package com.example.recreationbase.presentaion

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.Blue
import com.example.recreationbase.ui.theme.Gray
import com.example.recreationbase.ui.theme.Orange
import com.example.recreationbase.ui.theme.Typography

@Composable
fun HeaderInfo() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item {
            HeaderInfoCell(
                backgroundColor = Orange,
                text = "+29°C",
                icon = R.drawable.sun_icon
            )
        }
        item {
            HeaderInfoCell(
                backgroundColor = Blue,
                text = "О базе отдыха",
                icon = R.drawable.question_icon
            )
        }
        item {
            HeaderInfoCell(
                backgroundColor = Gray,
                text = "Как добраться",
                icon = R.drawable.map_path_icon
            )
        }
    }
}

@Composable
private fun HeaderInfoCell(backgroundColor: Color, text: String, @DrawableRes icon: Int) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
    ) {
        Row {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.padding(start = 11.dp, top = 10.dp, bottom = 10.dp),
                tint = Color.White
            )
            Text(
                text = text,
                style = Typography.body1.copy(color = Color.White, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 11.dp, top = 10.dp, bottom = 10.dp, end = 11.dp)
            )
        }
    }
}