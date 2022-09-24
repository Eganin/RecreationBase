package com.example.recreationbase.presentaion.views

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recreationbase.R
import com.example.recreationbase.ui.theme.AppTheme

@Composable
fun BottomBar(navController: NavController) {
    val bottomItems = listOf(
        DestinationPage.MAIN.name,
        DestinationPage.MAP.name,
        DestinationPage.RESERVATION.name,
        DestinationPage.CHAT.name,
        DestinationPage.MORE.name,
    )
    
    BottomNavigation(backgroundColor = AppTheme.colors.primaryBackground) {
        bottomItems.forEach { screen ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val isSelected = navBackStackEntry?.destination?.hierarchy
                ?.any { it.route == screen } == true
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = {
                    getIconForBottomBar(screen = screen, isSelected = isSelected)
                })
        }
    }
}

@Composable
private fun getIconForBottomBar(screen: String, isSelected: Boolean = false) {
    return when (screen) {
        DestinationPage.MAIN.name -> Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription = "Search",
            tint = if (isSelected) AppTheme.colors.tintColor else AppTheme.colors.primaryText
        )
        DestinationPage.MAP.name -> Icon(
            painter = painterResource(id = R.drawable.map),
            contentDescription = "Search",
            tint = if (isSelected) AppTheme.colors.tintColor else AppTheme.colors.primaryText
        )
        DestinationPage.RESERVATION.name -> Icon(
            painter = painterResource(id = R.drawable.reservation),
            contentDescription = "Search",
            tint = if (isSelected) AppTheme.colors.tintColor else AppTheme.colors.primaryText
        )
        DestinationPage.CHAT.name -> Icon(
            painter = painterResource(id = R.drawable.chat),
            contentDescription = "Search",
            tint = if (isSelected) AppTheme.colors.tintColor else AppTheme.colors.primaryText
        )
        DestinationPage.MORE.name -> Icon(
            painter = painterResource(id = R.drawable.more),
            contentDescription = "Search",
            tint = if (isSelected) AppTheme.colors.tintColor else AppTheme.colors.primaryText
        )
        else -> {}
    }
}

enum class DestinationPage {
    MAIN,
    MAP,
    RESERVATION,
    CHAT,
    MORE
}