package com.aregyan.compose.repository

import android.content.Context
import com.aregyan.compose.domain.Item
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemRepository(context: Context, moshi: Moshi) {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    init {
        val json = context.assets.open("sample_list_data.json").bufferedReader().use { it.readText() }
        val type = Types.newParameterizedType(List::class.java, Item::class.java)
        val adapter = moshi.adapter<List<Item>>(type)
        _items.value = adapter.fromJson(json) ?: emptyList()
    }

    fun deleteItem(item: Item) {
        _items.value = _items.value.toMutableList().apply { remove(item) }
    }

    fun sortItemsBy(criteria: String) {
        _items.value = when (criteria) {
            "title" -> _items.value.sortedBy { it.title }
            "date" -> _items.value.sortedBy { it.date }
            "index" -> _items.value.sortedBy { it.index }
            else -> _items.value
        }
    }
}
