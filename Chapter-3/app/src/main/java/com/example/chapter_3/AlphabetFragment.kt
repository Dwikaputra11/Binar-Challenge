package com.example.chapter_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3.adapter.AlphabetListAdapter
import kotlinx.android.synthetic.main.activity_main.*
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
        val listAlphabet  = arrayListOf<String>(
            "A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","R","S","T","U",
            "V","W","X","Y","Z"
        )

        val adapter = AlphabetListAdapter(listAlphabet)

        rvAlphabetList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvAlphabetList.adapter = adapter
        adapter.setOnItemClickListener(object : AlphabetListAdapter.onItemClickListener{
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