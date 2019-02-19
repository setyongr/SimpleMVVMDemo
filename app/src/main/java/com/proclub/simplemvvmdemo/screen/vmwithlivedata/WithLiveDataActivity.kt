package com.proclub.simplemvvmdemo.screen.vmwithlivedata

import android.os.Bundle
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

        viewModel.getCounter().observe(this, Observer {
            textData.text = it.toString()
        })

        buttonAdd.setOnClickListener {
            viewModel.increaseCounter()
        }
    }
}