package com.villalobosmarin.jocsantjordi.Games

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.MainActivity
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view


class Game01 : AppCompatActivity() {
    private var currentTag = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game01)

        val imageView1 = findViewById<ImageView>(R.id.img_rata)
        val imageView2 = findViewById<ImageView>(R.id.img_gallina)
        val imageView3 = findViewById<ImageView>(R.id.img_cerdo)
        val imageView4 = findViewById<ImageView>(R.id.img_caballo)
        val btnHome = findViewById<ImageButton>(R.id.btnHome_game01)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val clickListener = View.OnClickListener { v ->
            val clickedImageView = v as ImageView
            val tag = clickedImageView.tag.toString().toInt()
            if (tag == currentTag) {
                clickedImageView.visibility = View.GONE
                currentTag--
                if (currentTag == 0) {
                    showSuccessMessage()

                    val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

                    val editor = sharedPrefs.edit()

                    editor.putBoolean("starFilled", true)

                    editor.apply()
                }
            }
        }

        imageView1.setOnClickListener(clickListener)
        imageView2.setOnClickListener(clickListener)
        imageView3.setOnClickListener(clickListener)
        imageView4.setOnClickListener(clickListener)
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


