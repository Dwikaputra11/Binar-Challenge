package com.example.chapter_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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
        val adapter = AlphabetListAdapter(DummyData.listAlphabet)

        fabAddWord.setOnClickListener{
            val addWordBottomSheetFragment = AddWordBottomSheetFragment()
            addWordBottomSheetFragment.show(parentFragmentManager.beginTransaction(),addWordBottomSheetFragment.tag)
        }

        rvAlphabetList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvAlphabetList.adapter = adapter
        adapter.setOnItemClickListener(object : AlphabetListAdapter.onItemClickListener{
            override fun onItemClick(word: String) {
                val bundle = Bundle()
                bundle.putString("key_word", word)
                Navigation.findNavController(view).navigate(R.id.action_alphabetFragment_to_alphabetWordFragment, bundle)
            }
        })

    }

}