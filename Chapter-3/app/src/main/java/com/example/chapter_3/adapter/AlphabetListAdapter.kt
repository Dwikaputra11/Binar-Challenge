package com.example.chapter_3.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3.R
import kotlinx.android.synthetic.main.alphabet_list.view.*

class AlphabetListAdapter(private val listAlphabet: ArrayList<String>) :
    RecyclerView.Adapter<AlphabetListAdapter.ViewHolder>(){

    private lateinit var listener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listener = listener
    }

    class ViewHolder(itemView: View,  listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val character = itemView.tvChar
        init {
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alphabet_list, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.character.text = listAlphabet[position]
    }

    override fun getItemCount(): Int = listAlphabet.size

}

