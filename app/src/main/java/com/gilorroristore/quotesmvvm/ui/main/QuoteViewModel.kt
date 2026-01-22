package com.gilorroristore.quotesmvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import com.gilorroristore.quotesmvvm.data.network.provider.QuoteProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val provider: QuoteProvider) : ViewModel() {
    val quiteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = provider.random()
        quiteModel.postValue(currentQuote)
    }

}