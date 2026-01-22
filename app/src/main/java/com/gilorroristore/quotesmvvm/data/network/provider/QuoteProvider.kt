package com.gilorroristore.quotesmvvm.data.network.provider

import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import javax.inject.Inject

class QuoteProvider @Inject constructor() {
        companion object {
        var quotes: List<QuoteModel> = emptyList()
    }
}