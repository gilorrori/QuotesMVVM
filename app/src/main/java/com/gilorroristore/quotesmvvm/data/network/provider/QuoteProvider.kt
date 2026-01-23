package com.gilorroristore.quotesmvvm.data.network.provider

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}