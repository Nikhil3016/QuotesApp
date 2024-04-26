package com.nk.quotes.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nk.quotes.model.Quote

@Composable
fun QuoteListScreen(quotes: Array<Quote>, onClick: (Quote) -> Unit) {
    Text(
        text = "Quotes App",
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth(1f)
            .padding(20.dp)
    )
    QuoteList(quoteList = quotes) {
        onClick(it)
    }
}
