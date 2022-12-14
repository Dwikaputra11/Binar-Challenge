package com.example.chapter_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_3.adapter.AlphabetListAdapter
import com.example.chapter_3.data.DummyData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_alphabet.*

class AlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).supportActionBar?.title = "Words"
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (activity as MainActivity).fabAddWord.visibility = View.VISIBLE
        val alphabetListAdapter = AlphabetListAdapter(DummyData.listAlphabet)
        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        lm.stackFromEnd = true
        rvAlphabetList.layoutManager = lm
        rvAlphabetList.adapter = alphabetListAdapter

        alphabetListAdapter.setOnItemClickListener(object : AlphabetListAdapter.OnItemClickListener{
            override fun onItemClick(word: String) {
                loadFragment(AlphabetWordFragment(word))
            }
        })
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frContainer, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}