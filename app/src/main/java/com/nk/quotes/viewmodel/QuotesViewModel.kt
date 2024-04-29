package com.nk.quotes.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nk.quotes.model.response.QuotesResponseModel
import com.nk.quotes.model.response.Result
import com.nk.quotes.repository.QuotesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuotesViewModel(
    application: Application
): AndroidViewModel(application) {
    private val quotesRepository = QuotesRepository()

    private val _quotes = MutableLiveData<List<Result>>()
    val quotes: LiveData<List<Result>> = _quotes

    fun getQuotes() {
        val data = quotesRepository.getQuotes()
        data.enqueue(object : Callback<QuotesResponseModel> {
            override fun onResponse(
                p0: Call<QuotesResponseModel>,
                response: Response<QuotesResponseModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val responseData = response.body()
                    _quotes.value = responseData?.results
                }
            }

            override fun onFailure(p0: Call<QuotesResponseModel>, p1: Throwable) {
                Toast.makeText(getApplication(), p1.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}