package com.example.recreationbase.presentaion.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val errorColor: Color,
    val cardBackground : Color
)

object AppTheme{
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No colors providers")
}