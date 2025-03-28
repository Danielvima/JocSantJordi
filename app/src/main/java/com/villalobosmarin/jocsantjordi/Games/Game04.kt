package com.villalobosmarin.jocsantjordi.Games

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.MainActivity
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view

class Game04 : AppCompatActivity() {

    private val imagesAndWords = mapOf(
        R.drawable.drac_cv to "DRAC",
        R.drawable.princesa_1 to "PRINCESA",
        R.drawable.caballero_cv to "SANTJORDI",
        R.drawable.rosa_cv to "ROSA",
        R.drawable.rei_cv to "REI",
        R.drawable.libro_img to "LLIBRE",
        R.drawable.animal_gallina to "GALLINA"
        )

    private val incorrectWords = listOf("CASA", "PILOTA", "JOC", "ARBRE", "GOS", "GAT", "SOL", "LLAMP","MAR","PEIX")
    private lateinit var answerButtons: List<Button>
    private lateinit var randomImageView: ImageView
    private lateinit var dragonHealthTextView: TextView
    private lateinit var caballeroHealthTextView: TextView
    private lateinit var starImageView: ImageView
    private lateinit var mediaPlayer: MediaPlayer

    private var dragonHealth = 220
    private var caballeroHealth = 100
    private var stars = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game04)

        val btnHome = findViewById<ImageButton>(R.id.btnHome_game05)
        btnHome.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.atck_sound)

        answerButtons = listOf(
            findViewById(R.id.answer1),
            findViewById(R.id.answeer2),
            findViewById(R.id.answer3),
            findViewById(R.id.answer4)
        )

        randomImageView = findViewById(R.id.random_Images)
        dragonHealthTextView = findViewById(R.id.dragonHealthTextView)
        caballeroHealthTextView = findViewById(R.id.caballeroHealthTextView)
        starImageView = findViewById(R.id.imageView17)

        showNextRandomImage()
    }

    private fun showNextRandomImage() {
        val randomEntry = imagesAndWords.entries.random()
        randomImageView.setImageResource(randomEntry.key)

        val correctWord = randomEntry.value
        val incorrectWord1 = incorrectWords.random()
        val incorrectWord2 = incorrectWords.random()
        val incorrectWord3 = incorrectWords.random()

        val words = listOf(correctWord, incorrectWord1, incorrectWord2, incorrectWord3).shuffled()

        for (i in answerButtons.indices) {
            answerButtons[i].text = words[i]
            answerButtons[i].setOnClickListener {
                if (answerButtons[i].text == correctWord) {
                    reduceDragonHealth()
                } else {
                    reduceCaballeroHealth()
                }
                playSound()
                showNextRandomImage()
            }
        }
    }

    private fun reduceDragonHealth() {
        dragonHealth -= 40
        if (dragonHealth <= 0) {
            val finishcv = findViewById<CardView>(R.id.finishcv)
            finishcv.visibility = View.VISIBLE
            val nextLevelButton = findViewById<Button>(R.id.nextLevelButton)
            nextLevelButton.setOnClickListener {
                val intent = Intent(this, map_view::class.java)
                startActivity(intent)
            }
            updateStars()
        }
        dragonHealthTextView.text = dragonHealth.toString()
    }

    private fun reduceCaballeroHealth() {
        caballeroHealth -= 40
        if (caballeroHealth <= 0) {
            showGameOverAlert()
        }
        caballeroHealthTextView.text = caballeroHealth.toString()
    }

    private fun showGameOverAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("OH NO, T'HAN MATAT!!")
        builder.setMessage("VOLS TORNAR AL MAPA O TORNAR A JUGAR")
        builder.setPositiveButton("TORNAR A JUGAR") { dialog, _ ->
            resetGame()
            dialog.dismiss()
        }
        builder.setNegativeButton("ANAR AL MAPA") { dialog, _ ->
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }

        builder.setCancelable(false)
        builder.show()
    }

    private fun resetGame() {
        dragonHealth = 220
        caballeroHealth = 100
        dragonHealthTextView.text = dragonHealth.toString()
        caballeroHealthTextView.text = caballeroHealth.toString()
        stars = 0
        updateStars()
        showNextRandomImage()
    }

    private fun updateStars() {
        stars++
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putInt("stars", stars)
        editor.apply()
        starImageView.setImageResource(if (stars >= 1) R.drawable.ic_star_on else R.drawable.ic_star_off)
    }

    private fun playSound() {
        mediaPlayer.start()
    }
}

