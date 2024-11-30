package com.aregyan.compose.domain

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Item(
    val index: Int,
    val title: String,
    val date: Date,
    val description: String
)
