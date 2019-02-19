package com.proclub.simplemvvmdemo.screen.vmwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MySecondViewModel: ViewModel() {
    private val _counter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }

    fun getCounter() = _counter as LiveData<Int>

    fun increaseCounter() {
        val currentValue = _counter.value ?: 0
        _counter.value = currentValue + 1
    }
}