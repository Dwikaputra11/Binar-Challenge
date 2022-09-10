package com.example.chapter_3.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter_3.R
import com.example.chapter_3.model.Word
import kotlinx.android.synthetic.main.alphabet_word_preview.view.*

class AlphabetWordPreviewAdapter(private val wordPreviewList: ArrayList<Word>):
    RecyclerView.Adapter<AlphabetWordPreviewAdapter.ViewHolder>() {

    private lateinit var listener: AlphabetWordPreviewAdapter.OnItemClickListener
    private lateinit var context: Context
    interface OnItemClickListener{
        fun onItemClick(word: String)
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val wordPreview = itemView.tvWordPreview
        val imageWordPreview: ImageView = itemView.ivWordPreview
        init {
            itemView.setOnClickListener{
                listener.onItemClick(wordPreviewList[absoluteAdapterPosition].word)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_word_preview, parent, false)
        context = parent.context
        return ViewHolder(itemView = view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordPreview.text = wordPreviewList[position].word
        Glide.with(context)
            .load(wordPreviewList[position].image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageWordPreview)
    }

    override fun getItemCount(): Int {
        return wordPreviewList.size
    }
}