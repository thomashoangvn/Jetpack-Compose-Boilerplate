package com.aregyan.compose.ui.items


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.runtime.Composable

@Composable
fun ListScreen(navController: NavController, viewModel: ItemViewModel) {
    val items by viewModel.items.collectAsState()

    Column {
        Row {
            Button(onClick = { viewModel.sortItems("title") }) { Text("Sort by Title") }
            Button(onClick = { viewModel.sortItems("date") }) { Text("Sort by Date") }
            Button(onClick = { viewModel.sortItems("index") }) { Text("Sort by Index") }
        }

        LazyColumn {
            items(items) { item ->
                ItemView(
                    item = item,
                    onDelete = { viewModel.deleteItem(it) },
                    onClick = { navController.navigate("detail/${item.index}") }
                )
            }
        }
    }
}
