package com.example.s205452lykkehjulet.Adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.s205452lykkehjulet.R

class LifeRecyclerAdapter(var lives: Int): RecyclerView.Adapter<LifeRecyclerAdapter.LifeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.life_card, parent, false)
        return LifeViewHolder(inflater)
    }


    inner class LifeViewHolder(cardView: View): RecyclerView.ViewHolder(cardView){
        var lifeCard: CardView = cardView.findViewById(R.id.lifeImage)

        init{
            lifeCard = cardView.findViewById(R.id.lifeImage)
        }
    }

    override fun onBindViewHolder(holder: LifeViewHolder, position: Int) {
        //val life = lives[position]
        //holder.lifeCard = lives
    }

    override fun getItemCount(): Int {
        return lives
    }
}