package com.proclub.simplemvvmdemo.screen.withviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.proclub.simplemvvmdemo.R
import kotlinx.android.synthetic.main.activity_no_view_model.*

class WithViewModelActivity: AppCompatActivity() {
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_view_model)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        buttonAdd.setOnClickListener {
            viewModel.mData = "This is data stored in ViewModel"
            textData.text = viewModel.mData
        }

        textData.text = viewModel.mData
    }
}