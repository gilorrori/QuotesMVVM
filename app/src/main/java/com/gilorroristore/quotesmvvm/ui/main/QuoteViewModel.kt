package com.gilorroristore.quotesmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilorroristore.quotesmvvm.data.network.model.QuoteModel
import com.gilorroristore.quotesmvvm.domain.usecase.GetQuotesUseCase
import com.gilorroristore.quotesmvvm.domain.usecase.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val quotesUseCase: GetQuotesUseCase, private val randomQuoteUseCase: GetRandomQuoteUseCase) :
    ViewModel() {
    private var _quiteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    val quiteModel: LiveData<QuoteModel> = _quiteModel


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = quotesUseCase()

            if (result.isNotEmpty()) {
                _quiteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        val random: QuoteModel? = randomQuoteUseCase()

        random?.let {
            _quiteModel.postValue(it)
        }
    }
}