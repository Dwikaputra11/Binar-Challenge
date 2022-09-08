package com.example.chapter_3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3.R
import com.example.chapter_3.model.Word
import kotlinx.android.synthetic.main.alphabet_word_preview.view.*

class AlphabetWordPreviewAdapter(private val wordPreviewList: ArrayList<Word>):
    RecyclerView.Adapter<AlphabetWordPreviewAdapter.ViewHolder>() {

    private lateinit var listener: AlphabetWordPreviewAdapter.OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(word: String)
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class ViewHolder(itemView:View, listener: OnItemClickListener, wordList: ArrayList<Word>):RecyclerView.ViewHolder(itemView) {
        val wordPreview = itemView.tvWordPreview
        val imageWordPreview: ImageView = itemView.ivWordPreview

        init {
            itemView.setOnClickListener{
                listener.onItemClick(wordList[absoluteAdapterPosition].word)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_word_preview, parent, false)
        return ViewHolder(itemView = view, listener = listener, wordList = wordPreviewList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordPreview.text = wordPreviewList[position].word
        holder.imageWordPreview.setImageResource(wordPreviewList[position].image)
    }

    override fun getItemCount(): Int {
        return wordPreviewList.size
    }
}