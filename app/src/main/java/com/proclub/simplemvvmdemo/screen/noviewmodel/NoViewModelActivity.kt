package com.proclub.simplemvvmdemo.screen.noviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proclub.simplemvvmdemo.R
import kotlinx.android.synthetic.main.activity_no_view_model.*

class NoViewModelActivity : AppCompatActivity() {
    private var mData: String = "No Data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_view_model)

        buttonAdd.setOnClickListener {
            mData = "This is the data"
            textData.text = mData
        }

        /** Un comment to fix rotation
        mData = savedInstanceState?.getString("data") ?: "No Data"
        **/
        textData.text = mData
    }

    /** Un comment to fix rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("data", mData)
    }
    **/
}