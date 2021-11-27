package com.example.s205452lykkehjulet.Adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.s205452lykkehjulet.R

class LifeRecyclerAdapter: RecyclerView.Adapter<LifeRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.life_card, parent, false)
        return ViewHolder(inflater)
    }


    inner class ViewHolder(cardView: View): RecyclerView.ViewHolder(cardView){
        var lifeCard: CardView

        init{
            lifeCard = cardView.findViewById(R.id.lifeImage)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}