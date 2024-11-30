package com.aregyan.compose.ui.items

import com.aregyan.compose.domain.Item
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aregyan.compose.util.toStringFormat

@Composable
fun ItemView(
    item: Item,
    onDelete: (Item) -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(),// 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.headlineSmall)
                Text(
                    text = "Date: ${item.date.toStringFormat()}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
//            IconButton(onClick = { onDelete(item) }) {
//                Icon(Icons.Default.Delete, contentDescription = "Delete Item")
//            }
        }
    }
}
