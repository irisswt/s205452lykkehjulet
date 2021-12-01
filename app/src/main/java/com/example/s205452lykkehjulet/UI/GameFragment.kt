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
import com.example.s205452lykkehjulet.*
import com.example.s205452lykkehjulet.Adapters.LetterRecyclerAdapter
import com.example.s205452lykkehjulet.Adapters.LifeRecyclerAdapter
import kotlin.random.Random

class GameFragment : Fragment() {

    private var charList = ArrayList<Letter>()
    private var guessedLetters = ArrayList<String>()
    private var isGuessed: Boolean = false
    private var score: Int = 0

    private var gameInProgress: Boolean = true
    private lateinit var scoreText: TextView
    private lateinit var lifeRecyclerView: RecyclerView
    private lateinit var userGuess: String
    private lateinit var text: TextView
    private lateinit var editText: EditText
    private lateinit var guessed: TextView
    private lateinit var word: List<String>
    private lateinit var letterAdapter: LetterRecyclerAdapter
    private lateinit var button: Button
    val wordGenerator = Word()


    var game = Game(5,0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game, container, false)
        button = view.findViewById(R.id.spin_button)
        val letterRecyclerView: RecyclerView = view.findViewById(R.id.letter_recycler_view)
        word = wordGenerator.generateWord()

        // Inflate the layout for this fragment

        text = view.findViewById(R.id.spin_text)
        text.text = "Category: " + wordGenerator.getWordCategory().uppercase()

        lifeRecyclerView = view.findViewById(R.id.life_recycler_view)
        editText = view.findViewById(R.id.guess_text)
        guessed = view.findViewById(R.id.guessed_letters)
        scoreText = view.findViewById(R.id.score)


        for (i in word.indices) {
            charList.add(Letter(word[i], false))
        }
        letterAdapter = LetterRecyclerAdapter(charList)
        letterRecyclerView.adapter = letterAdapter

        scoreText.setText("Score: " + game.score.toString())
        var lifeAdapter = LifeRecyclerAdapter(game.life)
        lifeRecyclerView.adapter = lifeAdapter
        //lifeAdapter.notifyDataSetChanged()


        button.setOnClickListener {
            lykkehjulet()
        }





        // https://www.tutorialspoint.com/how-to-create-horizontal-listview-in-android-using-kotlin
        val letterLinearLayoutManager = LinearLayoutManager(view.context)
        letterLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        letterRecyclerView.layoutManager = letterLinearLayoutManager

        val lifeLinearLayoutManager = LinearLayoutManager(view.context)
        lifeLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        lifeRecyclerView.layoutManager = lifeLinearLayoutManager



        return view
    }
    fun lykkehjulet() {
        var gamePhase = GamePhase.SPIN
        var wheelOption: WheelOption.WheelOption
        userGuess = editText.text.toString().uppercase()

            if (gamePhase == GamePhase.SPIN) {

                button.text = "Spin the wheel!"
                gamePhase = GamePhase.GUESS
            }

            if (gamePhase == GamePhase.GUESS) {

                button.text = "Click to guess"
                for (i in guessedLetters.indices) {
                    if (userGuess.equals(guessedLetters[i])) {
                        isGuessed = true
                        break
                    } else {
                        isGuessed = false
                    }
                }
                if (!isGuessed) {
                    guessedLetters.add(userGuess)
                    guessed.append(userGuess + " ")
                    for (i in word.indices) {
                        if (charList[i].letter.equals(userGuess)) {
                            charList[i] = Letter(word[i], true)
                            letterAdapter.notifyDataSetChanged()
                        }
                    }
                }

                editText.setText("")
                gamePhase = GamePhase.SPIN
            }


        }


}