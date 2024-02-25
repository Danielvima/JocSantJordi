package com.villalobosmarin.jocsantjordi.Games

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.villalobosmarin.jocsantjordi.MainActivity
import com.villalobosmarin.jocsantjordi.R


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
                    currentTag = 4
                    imageView1.visibility = View.VISIBLE
                    imageView2.visibility = View.VISIBLE
                    imageView3.visibility = View.VISIBLE
                    imageView4.visibility = View.VISIBLE
                }
            }
        }

        imageView1.setOnClickListener(clickListener)
        imageView2.setOnClickListener(clickListener)
        imageView3.setOnClickListener(clickListener)
        imageView4.setOnClickListener(clickListener)
    }
}


