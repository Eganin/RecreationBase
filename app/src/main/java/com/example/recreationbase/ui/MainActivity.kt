package com.example.recreationbase.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recreationbase.presentaion.MainPage
import com.example.recreationbase.presentaion.MainViewModel
import com.example.recreationbase.presentaion.blogdetail.BlogDetailPage
import com.example.recreationbase.presentaion.blogdetail.BlogDetailViewModel
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.RecreationBaseTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val blogDetailViewModel: BlogDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecreationBaseTheme {
                val systemUiController = rememberSystemUiController()
                val statusBarColor = AppTheme.colors.primaryBackground
                val navController: NavHostController = rememberNavController()
                SideEffect {
                    // setup status bar
                    systemUiController.apply {
                        setSystemBarsColor(color = statusBarColor)
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.primaryBackground
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomBar(navController = navController)
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = DestinationPage.MAIN.name
                        ) {
                            composable("BlogDetail") { navBackStackEntry ->
                                val id =
                                    navController.previousBackStackEntry?.savedStateHandle?.get<Int>(
                                        "ID_KEY"
                                    )
                                id?.let {
                                    BlogDetailPage(
                                        id = it,
                                        viewModel = blogDetailViewModel,
                                        navController = navController
                                    )
                                }
                            }

                            composable(DestinationPage.MAIN.name) {
                                MainPage(viewModel = mainViewModel, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}
