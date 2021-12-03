package com.example.s205452lykkehjulet.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.s205452lykkehjulet.R

class EndMessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_end_message, container, false)

        val bundle: Bundle? = getArguments()
        val gameScore: Int = bundle!!.getInt("point")
        var isWon: Boolean = bundle!!.getBoolean("isWon")
        val endMessageScore: TextView = view.findViewById(R.id.endmessage_score)
        endMessageScore.text = gameScore.toString()
        val endMessageMessage: TextView = view.findViewById(R.id.endmessage_message)
        endMessageMessage.text = "Game over"
        if(isWon){
            endMessageMessage.append("\n" +
                    "Congratulations, you've won.\n")

        }
        if(!isWon){
            endMessageMessage.append("\n" +
                    "Aww, you lost.\n")
        }
        endMessageMessage.append("Here's your score: $endMessageScore")


        return view
    }

}