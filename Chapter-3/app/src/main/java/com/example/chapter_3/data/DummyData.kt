package com.example.chapter_3.data

import com.example.chapter_3.R
import com.example.chapter_3.model.Word

class DummyData {
    companion object{
        val listAlphabet  = arrayListOf<String>(
            "A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","R","S","T","U",
            "V","W","X","Y","Z"
        )
        val word = arrayListOf<String>(
            "Anu", "Ngadan", "Kalo", "Miso", "Andar"
        )
        val listWordPreview = arrayListOf<Word>(
            Word("Anda", R.drawable.ic_launcher_background),
            Word("Misuh", R.drawable.ic_launcher_background),
            Word("Laut", R.drawable.ic_launcher_background),
            Word("Udara", R.drawable.ic_launcher_background),
            Word("Api", R.drawable.ic_launcher_background),


        )
    }
}