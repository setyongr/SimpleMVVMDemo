package com.proclub.simplemvvmdemo.screen.navigation.addquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.proclub.simplemvvmdemo.R
import com.proclub.simplemvvmdemo.screen.navigation.QuotesViewModel
import kotlinx.android.synthetic.main.fragment_add_quotes.*


class AddQuotesFragment : Fragment() {
    private val viewModel by lazy {
        this.activity?.let {
            ViewModelProviders.of(it).get(QuotesViewModel::class.java)
        } ?: throw Error("Not a valid activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAdd.setOnClickListener {
            viewModel.addQuotes(textInputQuote.editText?.text.toString())
            findNavController().navigateUp()
        }
    }
}
