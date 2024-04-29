package com.nk.quotes.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuotesRetrofitHelper {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.quotable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
