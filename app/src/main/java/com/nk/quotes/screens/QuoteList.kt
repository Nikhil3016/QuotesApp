package com.nk.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.nk.quotes.model.Quote
import com.nk.quotes.model.response.Result

@Composable
fun QuoteList(quoteList: List<Result>, onClick: (quote: Result) -> Unit) {
    LazyColumn{
        items(quoteList) { quote ->
            QuoteListItem(quote, onClick)
        }
    }
}
