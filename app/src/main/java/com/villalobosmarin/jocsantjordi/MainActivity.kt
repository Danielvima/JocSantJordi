package com.villalobosmarin.jocsantjordi

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.start_soud)

        resetSharedPreferences()

        val BtnJugar = findViewById<Button>(R.id.btnJugar)
        BtnJugar.setOnClickListener {
            playSound()

            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }
    }

    private fun resetSharedPreferences() {
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putInt("stars", 0)
        editor.putBoolean("starFilled", false)
        editor.apply()
    }

    private fun playSound() {
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
