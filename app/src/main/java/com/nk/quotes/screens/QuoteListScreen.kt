package com.nk.quotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nk.quotes.model.Quote
import com.nk.quotes.model.response.Result

@Composable
fun QuoteListScreen(quotes: List<Result>, onClick: (quote: Result) -> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(8.dp, 20.dp)
                .fillMaxWidth(1f)
        )
        QuoteList(quoteList = quotes, onClick)
    }
}
