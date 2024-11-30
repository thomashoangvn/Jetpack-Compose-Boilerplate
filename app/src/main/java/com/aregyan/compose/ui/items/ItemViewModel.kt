package com.aregyan.compose.ui.items

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.aregyan.compose.domain.Item
import com.aregyan.compose.repository.ItemRepository

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    val items: StateFlow<List<Item>> = repository.items

    fun deleteItem(item: Item) = repository.deleteItem(item)

    fun sortItems(criteria: String) = repository.sortItemsBy(criteria)
}
