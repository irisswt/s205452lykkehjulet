package com.example.s205452lykkehjulet.Adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.s205452lykkehjulet.Letter
import com.example.s205452lykkehjulet.R

class LetterRecyclerAdapter(private val dataset: List<Letter>): RecyclerView.Adapter<LetterRecyclerAdapter.LetterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.letter_text, parent, false)
        return LetterViewHolder(inflater)
    }


    class LetterViewHolder(cardView: View): RecyclerView.ViewHolder(cardView){
        val letterText: TextView = cardView.findViewById(R.id.letterText)


    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = dataset[position]
        holder.letterText.text = letter.letter
        if(letter.visible){
            holder.letterText.visibility = View.VISIBLE
        }
        else{
            holder.letterText.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}