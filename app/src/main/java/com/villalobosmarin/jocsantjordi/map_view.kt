package com.villalobosmarin.jocsantjordi

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.villalobosmarin.jocsantjordi.Games.Game01
import com.villalobosmarin.jocsantjordi.Games.Game02
import com.villalobosmarin.jocsantjordi.Games.Game03
import com.villalobosmarin.jocsantjordi.Games.Game04
import com.villalobosmarin.jocsantjordi.Games.Game05
import com.villalobosmarin.jocsantjordi.Games.Game06
import com.villalobosmarin.jocsantjordi.bookReader.BookReader

class map_view : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view)

        mediaPlayer = MediaPlayer.create(this, R.raw.menu_click_sound)

        val bookImageView = findViewById<ImageView>(R.id.imageView19)

        bookImageView.setOnClickListener {
            val intent = Intent(this, BookReader::class.java)
            startActivity(intent)
        }

        val Buttonlvl1 = findViewById<Button>(R.id.Btnlvl1)
        val Buttonlvl2 = findViewById<Button>(R.id.Btnlvl2)
        val Buttonlvl3 = findViewById<Button>(R.id.Btnlvl3)
        val Buttonlvl4 = findViewById<Button>(R.id.Btnlvl4)
        val Buttonlvl5 = findViewById<Button>(R.id.Btnlvl5)
        val Buttonlvl6 = findViewById<Button>(R.id.Btnlvl6)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)

        Buttonlvl1.setOnClickListener {
            playSound()
            showGameDialog01("NIVELL 1")
        }
        Buttonlvl2.setOnClickListener {
            playSound()
            showGameDialog02("NIVELL 2")
        }
        Buttonlvl3.setOnClickListener {
            playSound()
            showGameDialog03("NIVELL 3")
        }
        Buttonlvl4.setOnClickListener {
            playSound()
            showGameDialog04("NIVELL 4")
        }
        Buttonlvl5.setOnClickListener {
            playSound()
            showGameDialog05("NIVELL 5")
        }
        Buttonlvl6.setOnClickListener {
            playSound()
            showGameDialog06("NIVELL 6")
        }

        btnHome.setOnClickListener {
            playSound()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showGameDialog01(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game01, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView01)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game01
            val intent = Intent(this@map_view, Game01::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showGameDialog02(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game02, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView02)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game02
            val intent = Intent(this@map_view, Game02::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showGameDialog03(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game03, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView03)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game03
            val intent = Intent(this@map_view, Game03::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showGameDialog04(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game04, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView04)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game04
            val intent = Intent(this@map_view, Game04::class.java)
            startActivity(intent)
        }

        dialog.show()
    }


    private fun showGameDialog05(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game05, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView05)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton4).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game05
            val intent = Intent(this@map_view, Game05::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showGameDialog06(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game06, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val starImageView = dialogView.findViewById<ImageView>(R.id.starView06)
        stars(dialogView, starImageView)

        dialogView.findViewById<Button>(R.id.playButton2).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game06
            val intent = Intent(this@map_view, Game06::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun stars(dialogView: View, starImageView: ImageView) {
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val starFilled = sharedPrefs.getBoolean("starFilled", false)

        if (starFilled) {
            starImageView.setImageResource(R.drawable.ic_star_on)
        } else {
            starImageView.setImageResource(R.drawable.ic_star_off)
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

//push