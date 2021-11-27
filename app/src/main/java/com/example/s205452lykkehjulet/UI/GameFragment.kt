package com.example.s205452lykkehjulet.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.s205452lykkehjulet.R
import com.example.s205452lykkehjulet.Word

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var word: List<String> = listOf()
        val wordGenerator = Word()
        word = wordGenerator.generateWord()

    // Inflate the layout for this fragment
    val view: View = inflater.inflate(R.layout.fragment_game, container, false)
        val button: Button = view.findViewById(R.id.spin_button)
        val text: TextView = view.findViewById(R.id.spin_text)

        button.setOnClickListener{
            text.text = word
        }

        for(i in word.indices){

        }


    return view
    }

}