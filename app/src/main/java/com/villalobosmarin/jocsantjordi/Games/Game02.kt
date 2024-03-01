package com.villalobosmarin.jocsantjordi.Games

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.MainActivity
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view

class Game02 : AppCompatActivity() {

    private val cardPairs = mutableListOf(
        R.drawable.caballero_cv,
        R.drawable.drac_cv,
        R.drawable.princesa_1,
        R.drawable.rei_cv
    )

    private var lastClickedCard: ImageView? = null
    private var pairsFound = 0
    private var flippedCardsCount = 0
    private var isProcessing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game02)

        initializeGame()

        val btnHome = findViewById<ImageButton>(R.id.btnHome_game02)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeGame() {

        val duplicatedPairs = cardPairs.toList().flatMap { listOf(it, it) }
        cardPairs.clear()
        cardPairs.addAll(duplicatedPairs)


        cardPairs.shuffle()


        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        for (i in 0 until gridLayout.childCount) {
            val imageView = gridLayout.getChildAt(i) as ImageView
            imageView.setImageResource(R.drawable.card_back)
            imageView.isEnabled = true
            imageView.tag = i
        }
    }


    fun onCardClicked(view: android.view.View) {
        if (isProcessing) return

        val imageView = view as ImageView
        if (imageView == lastClickedCard) return

        val clickedIndex = imageView.tag.toString().toInt()

        if (lastClickedCard == null) {

            lastClickedCard = imageView
            imageView.setImageResource(cardPairs[clickedIndex])
            imageView.isEnabled = false
            flippedCardsCount++
        } else {

            isProcessing = true
            imageView.setImageResource(cardPairs[clickedIndex])
            imageView.isEnabled = false
            flippedCardsCount++

            if (cardPairs[lastClickedCard!!.tag.toString().toInt()] == cardPairs[clickedIndex]) {

                pairsFound++
                if (pairsFound == cardPairs.size / 2) {

                    showSuccessMessage()

                    val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

                    val editor = sharedPrefs.edit()

                    editor.putBoolean("starFilled", true)

                    editor.apply()

                }
                lastClickedCard = null
                isProcessing = false
            } else {

                Handler().postDelayed({
                    imageView.setImageResource(R.drawable.card_back)
                    imageView.isEnabled = true
                    lastClickedCard!!.setImageResource(R.drawable.card_back)
                    lastClickedCard!!.isEnabled = true
                    lastClickedCard = null
                    isProcessing = false
                }, 1000)

            }
        }
    }



    private fun showSuccessMessage() {


        val congratsCardView = findViewById<CardView>(R.id.congratsCardView)
        congratsCardView.visibility = View.VISIBLE
        val nextLevelButton = findViewById<Button>(R.id.nextLevelButton)
        nextLevelButton.setOnClickListener {
            // Ir al map_view
            val intent = Intent(this, map_view::class.java)
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
}



