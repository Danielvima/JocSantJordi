package com.villalobosmarin.jocsantjordi.Games

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view

class Game03 : AppCompatActivity() {

    private lateinit var dragonImageView: ImageView
    private lateinit var animalImageViews: Array<ImageView>
    private lateinit var textView: TextView
    private lateinit var congratsCardView: CardView

    private val animals = arrayOf("PORC", "CAVALL", "OVELLA", "GALLINA")
    private var currentAnimalIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game03)

        // Initialize views
        dragonImageView = findViewById(R.id.dragonImageView)
        animalImageViews = arrayOf(
            findViewById(R.id.animal1ImageView),
            findViewById(R.id.animal2ImageView),
            findViewById(R.id.animal3ImageView),
            findViewById(R.id.animal4ImageView)
        )
        textView = findViewById(R.id.textView)
        congratsCardView = findViewById(R.id.congratsCardView)

        // Set initial text
        textView.text = "VULL UN ${animals[currentAnimalIndex]}"

        // Set onClickListener for each animal ImageView
        animalImageViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                if (index == currentAnimalIndex) {
                    hideCurrentAnimal()
                    showNextAnimal()
                } else {
                    Toast.makeText(this, "Selecciona la imagen correcta", Toast.LENGTH_SHORT).show()
                }
            }
        }


        // Set onClickListener for the nextLevelButton
        val nextLevelButton = findViewById<Button>(R.id.nextLevelButton)
        nextLevelButton.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }
    }

    private fun hideCurrentAnimal() {
        // Ocultar la imagen del animal actual
        animalImageViews[currentAnimalIndex].visibility = View.GONE
    }

    private fun showNextAnimal() {
        currentAnimalIndex++
        if (currentAnimalIndex < animals.size) {
            textView.text = "VULL UN ${animals[currentAnimalIndex]}"
        } else {
            // Show congrats card view and hide dragon image
            congratsCardView.visibility = View.VISIBLE


        }
    }
}
