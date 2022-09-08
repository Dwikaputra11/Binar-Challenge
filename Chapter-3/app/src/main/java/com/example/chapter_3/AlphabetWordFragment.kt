package com.example.chapter_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_3.adapter.AlphabetWordAdapter
import kotlinx.android.synthetic.main.fragment_alphabet_word.*

class AlphabetWordFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val word = arrayListOf<String>(
            "Anu", "Ngadan", "Kalo", "Miso", "Andar", "Anjas", "Budi", "Banu", "Bakar"
        )

        val keyWord = arguments?.getString("key_word")
        val adapter = AlphabetWordAdapter(word.filter {
            it.first().toString().uppercase() == keyWord
        } as ArrayList<String>)
        rvAlphabetWord.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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