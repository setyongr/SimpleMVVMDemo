package com.proclub.simplemvvmdemo.screen.vmwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proclub.simplemvvmdemo.data.remote.APIService
import com.proclub.simplemvvmdemo.data.remote.Response
import kotlinx.coroutines.*

class MySecondViewModel: ViewModel() {
    private val job: Job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    private val _counter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }
    val counter = _counter as LiveData<Int>

    fun increaseCounter() {
        val currentValue = _counter.value ?: 0
        _counter.value = currentValue + 1
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading as LiveData<Boolean>

    private val _repos = MutableLiveData<List<Response.Repo>>()
    val repos = _repos as LiveData<List<Response.Repo>>

    fun getRepo() = scope.launch {
        val service = APIService.create()
        _isLoading.value = true
        try {
            val repos = service.listRepos("setyongr")
            _isLoading.value = false
            _repos.value = repos
        } catch (e: Throwable) {
            _isLoading.value = false
        }

    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}