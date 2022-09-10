package com.example.chapter_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.Visibility
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_3.adapter.AlphabetWordAdapter
import com.example.chapter_3.data.DummyData
import com.example.chapter_3.model.Word
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_alphabet_word.*

class AlphabetWordFragment(private val keyWord :String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alphabet_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as MainActivity).supportActionBar?.title = "Words That Start With $keyWord"

        // show back button on toolbar
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as MainActivity).toolbar.setNavigationOnClickListener {
            (activity as MainActivity).supportFragmentManager.popBackStack()
        }
        // change floating button visibility
        (activity as MainActivity).fabAddWord.visibility = View.GONE

        // filter word by selected alphabet
        val adapter = AlphabetWordAdapter(DummyData.listWord.filter {
            it.word.first().toString().uppercase() == keyWord
        } as ArrayList<Word>)

        rvAlphabetWord.layoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)
        rvAlphabetWord.adapter = adapter

        adapter.setOnItemClickListener(object : AlphabetWordAdapter.OnItemClickListener{
            override fun onItemClick(word: String) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=$word")
                startActivity(intent)
            }
        })
    }
}