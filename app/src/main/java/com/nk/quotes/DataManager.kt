package com.nk.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.nk.quotes.model.Quote
import com.nk.quotes.model.response.Result

object DataManager {
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var clickedQuote: Result? = null

    fun loadAssets (context: Context) {
        val inputStream = context.assets.open("Quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray (size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson (json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Result?) {
        if (currentPage.value == Pages.LISTING) {
            clickedQuote = quote
            currentPage.value = Pages.DETAIL
        }
        else {
            currentPage.value = Pages.LISTING
        }
    }
}
