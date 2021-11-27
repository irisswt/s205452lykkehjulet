package com.example.s205452lykkehjulet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.s205452lykkehjulet.R
import com.example.s205452lykkehjulet.Word
import com.example.s205452lykkehjulet.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


    // Inflate the layout for this fragment
    val view: View = inflater.inflate(R.layout.fragment_game, container, false)
        val button: Button = view.findViewById(R.id.spin_button)
        val text: TextView = view.findViewById(R.id.spin_text)
    val wordGenerator = Word()
        button.setOnClickListener{
            text.text = wordGenerator.generateWord()
        }

    return view
    }

}