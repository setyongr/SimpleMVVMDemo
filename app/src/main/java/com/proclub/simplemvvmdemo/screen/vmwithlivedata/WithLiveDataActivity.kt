package com.proclub.simplemvvmdemo.screen.vmwithlivedata

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.proclub.simplemvvmdemo.R
import kotlinx.android.synthetic.main.activity_no_view_model.*

class WithLiveDataActivity: AppCompatActivity() {
    lateinit var viewModel: MySecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_view_model)

        viewModel = ViewModelProviders.of(this).get(MySecondViewModel::class.java)

        setUpCounter()
        setUpGetRepo()
    }

    private fun setUpCounter() {
        viewModel.counter.observe(this, Observer {
            textData.text = it.toString()
        })

        buttonAdd.setOnClickListener {
            viewModel.increaseCounter()
        }
    }

    private fun setUpGetRepo() {
        buttonGetRepo.setOnClickListener {
            viewModel.getRepo()
        }

        viewModel.isLoading.observe(this, Observer {
            loading.visibility = if (it) View.VISIBLE else View.GONE
            buttonGetRepo.isEnabled = !it
        })

        viewModel.repos.observe(this, Observer {
            textData2.text = it.first().name
        })
    }
}