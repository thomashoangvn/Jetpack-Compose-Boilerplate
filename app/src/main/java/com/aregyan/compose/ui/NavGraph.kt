package com.aregyan.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aregyan.compose.ui.items.DetailScreen
import com.aregyan.compose.ui.items.ItemViewModel
import com.aregyan.compose.ui.items.ListScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: ItemViewModel) {
    NavHost(navController, startDestination = "list") {
        composable("list") {
            ListScreen(navController, viewModel)
        }
        composable("detail/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt()
            val items = viewModel.items.collectAsState().value
            val item = items.find { it.index == index }
            item?.let {
                DetailScreen(navController, viewModel, it)
            }
        }
    }
}
