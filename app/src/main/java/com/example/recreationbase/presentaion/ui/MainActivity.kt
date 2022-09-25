package com.example.recreationbase.presentaion.ui

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recreationbase.presentaion.mainpage.MainPage
import com.example.recreationbase.presentaion.mainpage.MainViewModel
import com.example.recreationbase.presentaion.blogdetailpage.BlogDetailPage
import com.example.recreationbase.presentaion.blogdetailpage.BlogDetailViewModel
import com.example.recreationbase.presentaion.fooddetailpage.FoodDetailPage
import com.example.recreationbase.presentaion.fooddetailpage.FoodDetailViewModel
import com.example.recreationbase.presentaion.views.BottomBar
import com.example.recreationbase.presentaion.views.DestinationPage
import com.example.recreationbase.presentaion.ui.theme.AppTheme
import com.example.recreationbase.presentaion.ui.theme.RecreationBaseTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val blogDetailViewModel: BlogDetailViewModel by viewModels()
    private val foodDetailViewModel: FoodDetailViewModel by viewModels()

    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    private fun requestPermissions(){
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.CALL_PHONE,
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions()
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
                            startDestination = DestinationPage.MAIN.name,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(AppTheme.colors.primaryBackground)
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

                            composable("FoodDetail") { navBackStackEntry ->
                                val id =
                                    navController.previousBackStackEntry?.savedStateHandle?.get<Int>(
                                        "ID_KEY_FOOD"
                                    )
                                id?.let {
                                    FoodDetailPage(
                                        viewModel = foodDetailViewModel,
                                        id = id,
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
