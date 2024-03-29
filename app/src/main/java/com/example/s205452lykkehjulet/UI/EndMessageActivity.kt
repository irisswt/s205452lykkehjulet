package com.example.s205452lykkehjulet.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.s205452lykkehjulet.MainActivity
import com.example.s205452lykkehjulet.R

class EndMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_message)

        val gameScore: Int = intent.extras!!.getInt("point")
        var isGameWon: Boolean = intent.extras!!.getBoolean("isGameWon")
        Log.e("EMActivity", "point: " + gameScore + "\nisGameWon: "+isGameWon )

        val endMessageMessage: TextView = findViewById(R.id.endmessage_message)
        val playAgainButton: Button = findViewById(R.id.play_again_button)

        endMessageMessage.text = "Game over"
        if(isGameWon){
            endMessageMessage.append("\n" +
                    "Congratulations, you've won.\n")
        }
        if(!isGameWon){
            endMessageMessage.append("\n" +
                    "Aww, you lost.\n")
        }
        endMessageMessage.append("Here's your score: $gameScore")

        playAgainButton.setOnClickListener(){
            var intentTwo = Intent(this,MainActivity::class.java)
            startActivity(intentTwo)
        }
    }
}