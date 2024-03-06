package com.villalobosmarin.jocsantjordi.Games

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.MainActivity
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view

class Game05 : AppCompatActivity() {

    private lateinit var word1EditText: EditText
    private lateinit var word2EditText: EditText
    private lateinit var word3EditText: EditText
    private lateinit var word4EditText: EditText
    private lateinit var word5EditText: EditText
    private lateinit var word6EditText: EditText
    private lateinit var word7EditText: EditText
    private lateinit var checkButton: Button
    private lateinit var congratsCardView: CardView

    private val correctWords = arrayOf(
        "PRINCESA", "FERRO", "ROSA", "JARDI", "DRAC", "AMIGUES", "DAVANT"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game05)

        val btnHome = findViewById<ImageButton>(R.id.btnHome_game05)

        btnHome.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }
        congratsCardView = findViewById(R.id.congratsCardView)

        word1EditText = findViewById(R.id.word1EditText)
        word2EditText = findViewById(R.id.word2EditText)
        word3EditText = findViewById(R.id.word3EditText)
        word4EditText = findViewById(R.id.word4EditText)
        word5EditText = findViewById(R.id.word5EditText)
        word6EditText = findViewById(R.id.word6EditText)
        word7EditText = findViewById(R.id.word7EditText)
        checkButton = findViewById(R.id.checkButton)

        checkButton.setOnClickListener {
            checkAnswers()
        }

        val nextLevelButton = findViewById<Button>(R.id.nextLevelButton)
        nextLevelButton.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }


    }

    private fun checkAnswers() {
        val userAnswers = arrayOf(
            word1EditText.text.toString().toUpperCase(),
            word2EditText.text.toString().toUpperCase(),
            word3EditText.text.toString().toUpperCase(),
            word4EditText.text.toString().toUpperCase(),
            word5EditText.text.toString().toUpperCase(),
            word6EditText.text.toString().toUpperCase(),
            word7EditText.text.toString().toUpperCase()
        )

        var allCorrect = true
        for (i in correctWords.indices) {
            if (userAnswers[i] != correctWords[i]) {
                allCorrect = false
                Log.d("CheckAnswers", "Respuesta incorrecta: el usuario introdujo ${userAnswers[i]} pero se esperaba ${correctWords[i]}")
                break
            }
        }

        if (allCorrect) {
            congratsCardView.visibility = View.VISIBLE
            val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putBoolean("starFilled", true)
            editor.apply()
        } else {
            Toast.makeText(this, "Resposta incorrecta! Torna-ho a intentar", Toast.LENGTH_SHORT).show()
        }
    }


}

