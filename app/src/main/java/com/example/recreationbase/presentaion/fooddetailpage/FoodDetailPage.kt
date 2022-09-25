package com.example.recreationbase.presentaion.fooddetailpage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recreationbase.R
import com.example.recreationbase.presentaion.fooddetailpage.views.*
import com.example.recreationbase.presentaion.mainpage.views.LoaderAndError
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun FoodDetailPage(viewModel: FoodDetailViewModel, id: Int, navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = FoodDetailEvent.LoadInfo(id = id))
    }

    val state = viewModel.state

    BackdropScaffold(appBar = {},
        frontLayerScrimColor = Color.Transparent,
        backLayerBackgroundColor = Color.Transparent,
        frontLayerElevation = 5.dp,
        frontLayerShape = RoundedCornerShape(
            topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp
        ),
        backLayerContent = {
            state.info?.images?.let {
                FoodDetailImage(images = it)
            }
        }, frontLayerContent = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.primaryBackground)
                    .padding(bottom = 55.dp)
            ) {
                stickyHeader {
                    state.info?.title?.let {
                        Header(title = it, navController = navController)
                    }
                }
                item {
                    FoodDetailTitle(
                        title = state.info?.title ?: "",
                        subtitle = state.info?.subtitle ?: ""
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    state.info?.workingHours?.let {
                        FoodDetailWorkHoursView(
                            workingHours = it,
                            isOpen = state.info.close ?: false
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    state.info?.address?.let {
                        FoodDetailAddressView(address = it)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    state.info?.phone?.let {
                        FoodDetailContactsView(phoneNumber = it)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        state.info?.description?.let {
                            Text(
                                text = stringResource(R.string.description_label),
                                style = Typography.h5.copy(
                                    color = AppTheme.colors.primaryText,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = it,
                                style = Typography.body1.copy(color = AppTheme.colors.primaryText)
                            )
                        }
                    }
                }
            }
            LoaderAndError(collectionIsEmpty = state.info == null)
        })
}