package com.example.chapter_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.chapter_3.data.DummyData
import com.example.chapter_3.model.Word
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_word_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_add_word_bottom_sheet.view.*
import kotlin.random.Random as Random

class AddWordBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_word_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        btnAddWord.setOnClickListener{
            val word = etAddWord.text.toString()
            if(word.isNotBlank()){
                DummyData.listWord.add(Word(word,DummyData.images[(0..4).random()]))
                dismiss()
                Toast.makeText(context,"Word Added",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Invalid Input",Toast.LENGTH_SHORT).show()
            }
        }

    }
}