package com.proclub.simplemvvmdemo.screen.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proclub.simplemvvmdemo.data.FakeDataSource
import com.proclub.simplemvvmdemo.data.model.Quote

class QuotesViewModel: ViewModel() {
    private val _liveQuotes by lazy {
        MutableLiveData<List<Quote>>().apply {
            value = listOf()

            refreshQuotes()
        }
    }

    fun getQuotes() = _liveQuotes as LiveData<List<Quote>>

    private val _isLoading by lazy { MutableLiveData<Boolean>().apply { value = false } }

    fun getIsLoading() = _isLoading as LiveData<Boolean>

    fun refreshQuotes() {
        _isLoading.value = true
        FakeDataSource.getQuotes {
            _liveQuotes.value = it
            _isLoading.value = false
        }
    }

    fun addQuotes(message: String) {
        FakeDataSource.addQuotes(Quote(message))
        refreshQuotes()
    }
}