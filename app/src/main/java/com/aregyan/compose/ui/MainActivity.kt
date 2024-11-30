package com.aregyan.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aregyan.compose.ui.theme.JetpackComposeBoilerplateTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.aregyan.compose.ui.items.ItemViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBoilerplateTheme {
                //ComposeApp()
                val viewModel: ItemViewModel = hiltViewModel()
                val navController = rememberNavController()
                NavGraph(navController, viewModel)
            }
        }
    }
}