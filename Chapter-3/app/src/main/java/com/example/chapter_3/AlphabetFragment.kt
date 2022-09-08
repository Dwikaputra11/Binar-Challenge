package com.example.chapter_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_3.adapter.AlphabetListAdapter
import com.example.chapter_3.adapter.AlphabetWordPreviewAdapter
import com.example.chapter_3.data.DummyData
import com.example.chapter_3.model.Word
import kotlinx.android.synthetic.main.alphabet_list.*
import kotlinx.android.synthetic.main.fragment_alphabet.*

class AlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val alphabetListAdapter = AlphabetListAdapter(DummyData.listAlphabet)


        rvAlphabetList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvAlphabetList.adapter = alphabetListAdapter



        alphabetListAdapter.setOnItemClickListener(object : AlphabetListAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                loadFragment(AlphabetWordFragment())
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