package com.aregyan.compose.util

import java.text.SimpleDateFormat
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.Date
import java.util.Locale

fun Date.toStringFormat(pattern: String = "yyyy-MM-dd", locale: Locale = Locale.getDefault()): String {
    val dateFormat = SimpleDateFormat(pattern, locale)
    return dateFormat.format(this)
}

fun formatDate(dateUTC: String?) : String {
    if (dateUTC.isNullOrEmpty()) return ""

    val date = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(dateUTC)
    val newFormat = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
    return date?.let { newFormat.format(it) }.orEmpty()
}

class DateJsonAdapter {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    @FromJson
    fun fromJson(dateString: String): Date? {
        return try {
            dateFormat.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    @ToJson
    fun toJson(date: Date): String {
        return dateFormat.format(date)
    }
}
