package com.gilorroristore.quotesmvvm.data.repositories

import com.gilorroristore.quotesmvvm.data.QuoteApiService
import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import com.gilorroristore.quotesmvvm.data.network.provider.QuoteProvider
import com.gilorroristore.quotesmvvm.domain.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteApiService: QuoteApiService,
    private val quoteProvider: QuoteProvider
) : QuoteRepository {

    override suspend fun getAllQuotes(): List<QuoteModel> {
        val response = quoteApiService.getAllQuotes()
        quoteProvider.quotes = response
        return response
    }
}