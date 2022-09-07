package com.example.chapter_3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3.R
import kotlinx.android.synthetic.main.alphabet_word.view.*

class AlphabetWordAdapter(val listWord: ArrayList<String>):
    RecyclerView.Adapter<AlphabetWordAdapter.ViewHolder>() {

    private lateinit var listener: OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(word: String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
    class ViewHolder(itemView: View,listener: OnItemClickListener, wordList: ArrayList<String>): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener{
                listener.onItemClick(wordList[absoluteAdapterPosition])
            }
        }
        val word: TextView = itemView.findViewById<TextView>(R.id.tvWord)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_word, parent, false)
        return ViewHolder(view, listener, listWord)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.word.text = listWord[position]
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}