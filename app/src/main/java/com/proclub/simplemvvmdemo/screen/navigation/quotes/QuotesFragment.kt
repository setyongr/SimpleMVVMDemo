package com.proclub.simplemvvmdemo.screen.navigation.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.proclub.simplemvvmdemo.R
import com.proclub.simplemvvmdemo.screen.navigation.QuotesViewModel
import kotlinx.android.synthetic.main.fragment_quotes.*

class QuotesFragment : Fragment() {
    private val viewModel by lazy {
        this.activity?.let {
            ViewModelProviders.of(it).get(QuotesViewModel::class.java)
        } ?: throw Error("Not a valid activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuotes().observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                quotesContainer.text = "No Quotes"
            } else {
                quotesContainer.text = it.joinToString(separator = "\n") { it.message }
            }
        })

        viewModel.getIsLoading().observe(viewLifecycleOwner, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
            quotesContainer.visibility = if (it) View.GONE else View.VISIBLE
        })

        buttonAddQuotes.setOnClickListener {
            findNavController().navigate(R.id.action_quotesFragment_to_addQuotesFragment)
        }
    }
}
