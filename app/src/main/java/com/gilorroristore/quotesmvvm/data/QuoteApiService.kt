package com.gilorroristore.quotesmvvm.data

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiService {

    @GET("/.json")
    suspend fun getAllQuotes(): List<QuoteModel>
}