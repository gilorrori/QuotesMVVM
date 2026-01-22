package com.gilorroristore.quotesmvvm.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.gilorroristore.quotesmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val quoteViewModel by viewModels<QuoteViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        getQuotes()
        initObservers()
        initListener()
    }

    private fun getQuotes() {
        quoteViewModel.onCreate()
    }

    private fun initObservers() {
        quoteViewModel.isLoading.observe(this, Observer{
            binding.loading.isVisible = it
        })


        quoteViewModel.quiteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
    }

    private fun initListener() {
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}