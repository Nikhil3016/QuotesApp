package com.nk.quotes.retrofit

import com.nk.quotes.model.response.QuotesResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface QuotesApiService {
    @GET("/quotes")
    fun getQuotes(): Call<QuotesResponseModel>
}
