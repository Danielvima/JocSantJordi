package com.villalobosmarin.jocsantjordi

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class final : AppCompatActivity(){
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        mediaPlayer = MediaPlayer.create(this, R.raw.menu_click_sound)

        val btnHome = findViewById<ImageButton>(R.id.btnHomeF)
        btnHome.setOnClickListener {
            playSound()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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