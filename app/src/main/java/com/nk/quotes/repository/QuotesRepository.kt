package com.nk.quotes.repository

import com.nk.quotes.model.response.QuotesResponseModel
import com.nk.quotes.retrofit.QuotesApiService
import com.nk.quotes.retrofit.QuotesRetrofitHelper
import retrofit2.Call

class QuotesRepository {
    private val quotesApiService = QuotesRetrofitHelper.getInstance().create(QuotesApiService::class.java)

    fun getQuotes(): Call<QuotesResponseModel> {
        return quotesApiService.getQuotes()
    }
}
