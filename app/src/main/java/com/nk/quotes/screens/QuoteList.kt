package com.nk.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.nk.quotes.model.Quote

@Composable
fun QuoteList(quoteList: Array<Quote>, onClick: (Quote) -> Unit) {
    LazyColumn(content = {
        items(quoteList) { quote ->
            QuoteListItem(quote) {
                onClick(it)
            }
        }
    })
}
