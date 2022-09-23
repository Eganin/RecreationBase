package com.example.recreationbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recreationbase.presentaion.blogs.MainViewModel
import com.example.recreationbase.ui.theme.AppColors
import com.example.recreationbase.ui.theme.AppTheme
import com.example.recreationbase.ui.theme.RecreationBaseTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecreationBaseTheme {
                val systemUiController = rememberSystemUiController()
                val statusBarColor = AppTheme.colors.primaryBackground
                SideEffect {
                    // setup status bar
                    systemUiController.apply {
                        setSystemBarsColor(color = statusBarColor)
                    }
                }

                viewModel.downloadData()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.primaryBackground
                ) {

                }
            }
        }
    }
}
