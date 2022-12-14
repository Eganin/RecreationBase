package com.example.recreationbase.presentaion.blogdetailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.presentaion.blogdetailpage.views.DetailBlogTitle
import com.example.recreationbase.presentaion.blogdetailpage.views.ImageTop
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BlogDetailPage(id: Int, viewModel: BlogDetailViewModel, navController: NavController) {

    val state = viewModel.state

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = BlogDetailEvent.LoadInfo(id = id))
    }

    BackdropScaffold(appBar = {},
        frontLayerScrimColor = Color.Transparent,
        backLayerBackgroundColor = Color.Transparent,
        frontLayerElevation = 5.dp,
        frontLayerShape = RoundedCornerShape(
            topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp
        ),
        backLayerContent = {
            state.info?.image?.lg?.let {
                ImageTop(linkImage = it) {
                    navController.popBackStack()
                }
            }
        }, frontLayerContent = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.primaryBackground)
            ) {
                item {
                    state.info?.date?.let { date ->
                        state.info.subtitle?.let { subtitle ->
                            DetailBlogTitle(date = date, subtitle = subtitle)
                        }

                    }
                }
                item {
                    state.info?.content?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(16.dp),
                            style = Typography.body1.copy(color = AppTheme.colors.primaryText)
                        )
                    }
                }
            }
        })
}