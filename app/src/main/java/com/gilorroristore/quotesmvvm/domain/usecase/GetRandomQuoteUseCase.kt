package com.gilorroristore.quotesmvvm.domain.usecase

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import com.gilorroristore.quotesmvvm.data.network.provider.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val provider: QuoteProvider
) {

    operator fun invoke(): QuoteModel? {
        val quotes = provider.quotes
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}