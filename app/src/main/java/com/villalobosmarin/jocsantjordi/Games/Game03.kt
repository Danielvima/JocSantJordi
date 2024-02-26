package com.villalobosmarin.jocsantjordi.Games


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.villalobosmarin.jocsantjordi.R


class Game03 : AppCompatActivity(){

    private lateinit var dragonImageView: ImageView
    private lateinit var animalImageViews: Array<ImageView>
    private lateinit var checkButton: Button

    private val animalImages = arrayOf(
        R.drawable.drac_cv,
        R.drawable.archivement_icon,
        R.drawable.ic_pig,
        R.drawable.ic_star_on,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game03)

        dragonImageView = findViewById(R.id.dragonImageView)
        animalImageViews = arrayOf(
            findViewById(R.id.animal1ImageView),
            findViewById(R.id.animal2ImageView),
            findViewById(R.id.animal3ImageView),
            findViewById(R.id.animal4ImageView)
        )
        checkButton = findViewById(R.id.checkButton)

        checkButton.setOnClickListener {
            playGame()
        }

        playGame()
    }

    private fun playGame() {
        // Generar sumas aleatorias
        val randomNumbers = List(2) { (0 until animalImages.size).random() }
        val sum = randomNumbers.sum()

        // Mostrar al usuario las imágenes correspondientes
        dragonImageView.setImageResource(R.drawable.dragon_come)
        for (i in animalImageViews.indices) {
            val randomIndex = randomNumbers.getOrNull(i)
            randomIndex?.let {
                animalImageViews[i].setImageResource(animalImages[it])
            }
        }

        // Mostrar la suma que el dragón está pidiendo
        Toast.makeText(this, "Selecciona los animales que sumen $sum", Toast.LENGTH_SHORT).show()
    }
}

