package com.gilorroristore.quotesmvvm.domain.usecase

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import com.gilorroristore.quotesmvvm.domain.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend operator fun invoke(): List<QuoteModel> = quoteRepository.getAllQuotes()
}