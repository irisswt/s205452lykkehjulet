package com.example.s205452lykkehjulet

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class LifeRecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.life_card, parent, false)
        return ViewHolder(inflater)
    }


    inner class ViewHolder(cardView: View): RecyclerView.ViewHolder(cardView){
        var lifeCard: CardView

        init{
            lifeCard = cardView.findViewById(R.id.lifeImage)
        }
    }
}