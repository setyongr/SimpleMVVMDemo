package com.proclub.simplemvvmdemo.data

import android.os.Handler
import com.proclub.simplemvvmdemo.data.model.Quote

object FakeDataSource {
    private val mQuotes = mutableListOf<Quote>()

    private val handler = Handler()

    fun getQuotes(callback: (List<Quote>) -> Unit) {
        handler.postDelayed({
            callback(mQuotes)
        }, 1000)
    }
    fun addQuotes(quote: Quote) = mQuotes.add(quote)
}