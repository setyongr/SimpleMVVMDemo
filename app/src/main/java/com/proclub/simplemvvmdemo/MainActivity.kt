package com.proclub.simplemvvmdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proclub.simplemvvmdemo.screen.navigation.MainNavActivity
import com.proclub.simplemvvmdemo.screen.noviewmodel.NoViewModelActivity
import com.proclub.simplemvvmdemo.screen.vmwithlivedata.WithLiveDataActivity
import com.proclub.simplemvvmdemo.screen.withviewmodel.WithViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            startActivity(Intent(this, NoViewModelActivity::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, WithViewModelActivity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, WithLiveDataActivity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this, MainNavActivity::class.java))
        }
    }
}
