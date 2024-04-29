package com.nk.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.nk.quotes.model.response.Result
import com.nk.quotes.screens.QuoteDetail
import com.nk.quotes.screens.QuoteListItem
import com.nk.quotes.screens.QuoteListScreen
import com.nk.quotes.ui.theme.QuotesTheme
import com.nk.quotes.viewmodel.QuotesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: QuotesViewModel
    private val quotesList = arrayListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[QuotesViewModel::class.java]

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssets(this@MainActivity)
        }

        viewModel.getQuotes()



        setContent {
            QuotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: QuotesViewModel) {
    val list: ArrayList<Result> = arrayListOf()

    val myLiveDataState by viewModel.quotes.observeAsState()

    myLiveDataState?.let {
        list.addAll(it)
    }

    if (DataManager.currentPage.value == Pages.LISTING) {
        QuoteListScreen(list) { quote ->
            DataManager.switchPages(quote)
        }
    } else {
        DataManager.clickedQuote?.let {
            QuoteDetail(quote = it)
        }
    }

    /*if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(quotes) { quote ->
                DataManager.switchPages(quote)
            }
        } else {
            DataManager.clickedQuote?.let {
                QuoteDetail(quote = it)
            }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
            )
        }
    }*/
}

enum class Pages{
    LISTING,
    DETAIL
}