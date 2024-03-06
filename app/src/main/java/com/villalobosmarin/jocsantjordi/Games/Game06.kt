package com.villalobosmarin.jocsantjordi.Games

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
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.final
import com.villalobosmarin.jocsantjordi.map_view

class Game06 : AppCompatActivity() {
    private var imagesRemaining = 7
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game06)

        mediaPlayer = MediaPlayer.create(this, R.raw.img_click_sound)

        val btnHome = findViewById<ImageButton>(R.id.btnHome_game06)
        btnHome.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }

        val imageViews = arrayOf(
            findViewById<ImageView>(R.id.found_gallina),
            findViewById<ImageView>(R.id.found_caballo),
            findViewById<ImageView>(R.id.found_jordi),
            findViewById<ImageView>(R.id.found_princesa),
            findViewById<ImageView>(R.id.found_rei),
            findViewById<ImageView>(R.id.found_cerdo),
            findViewById<ImageView>(R.id.found_pez)
        )

        for (imageView in imageViews) {
            imageView.setOnClickListener {
                imageView.visibility = View.GONE
                imagesRemaining--
                updateImagesRemaining()
                playSound()
            }
        }
    }

    private fun updateImagesRemaining() {
        val contadorTextView = findViewById<TextView>(R.id.contador)

        contadorTextView.text = "PERSONATGES RESTANTS: $imagesRemaining"

        if (imagesRemaining == 0) {
            showSuccessMessage()
        }
    }

    private fun showSuccessMessage() {
        val congratsCardView = findViewById<CardView>(R.id.congratsCardView)
        congratsCardView.visibility = View.VISIBLE
        val nextLevelButton = findViewById<Button>(R.id.nextLevelButton)
        nextLevelButton.setOnClickListener {
            val intent = Intent(this, final::class.java)
            startActivity(intent)
        }

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val currentStars = sharedPrefs.getInt("stars", 0)
        val updatedStars = currentStars + 1
        with(sharedPrefs.edit()) {
            putInt("stars", updatedStars)
            apply()
        }
    }

    private fun playSound() {
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
