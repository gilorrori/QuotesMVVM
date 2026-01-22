package com.gilorroristore.quotesmvvm.domain

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel

interface QuoteRepository {
    suspend fun getAllQuotes(): List<QuoteModel>
}