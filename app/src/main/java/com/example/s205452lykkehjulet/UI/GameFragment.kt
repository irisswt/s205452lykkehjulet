package com.example.s205452lykkehjulet.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205452lykkehjulet.Adapters.LetterRecyclerAdapter
import com.example.s205452lykkehjulet.Game
import com.example.s205452lykkehjulet.Letter
import com.example.s205452lykkehjulet.R
import com.example.s205452lykkehjulet.Word

class GameFragment : Fragment() {

    private var charList = ArrayList<Letter>()
    private var score: Int = 0
    private lateinit var scoreText: TextView
    private lateinit var lifeRecyclerView: RecyclerView

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
        val letterRecyclerView: RecyclerView = view.findViewById(R.id.letter_recycler_view)
        lifeRecyclerView = view.findViewById(R.id.life_recycler_view)
        val editText: EditText = view.findViewById(R.id.guess_text)
        val guessed: TextView = view.findViewById(R.id.guessed_letters)
        scoreText = view.findViewById(R.id.score)
        var userGuess: String

        for (i in word.indices) {
            charList.add(Letter(word[i], false))
        }
        var letterAdapter = LetterRecyclerAdapter(charList)
        letterRecyclerView.adapter = letterAdapter

        button.setOnClickListener {
            userGuess = editText.text.toString().uppercase()
            text.text = userGuess
            guessed.append(userGuess + " ")
            for(i in word.indices){
                if(charList[i].letter.equals(userGuess)){
                    charList[i] = Letter(word[i], true)
                    Log.e("Linje 60", "onCreateView: " + "Dit gættede bogstav: " + word[i] )
                    letterAdapter.notifyDataSetChanged()
                }
                Log.e("Linje 63", "onCreateView: " + "Dit gættede bogstav: " + word[i] + userGuess)
            }
            lykkehjulet()
        }





        // https://www.tutorialspoint.com/how-to-create-horizontal-listview-in-android-using-kotlin
        val linearLayoutManager = LinearLayoutManager(view.context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        letterRecyclerView.layoutManager = linearLayoutManager






        return view
    }
    fun lykkehjulet(){
        var game = Game(5,0)
        scoreText.setText("Score: " + game.score.toString())

    }

}