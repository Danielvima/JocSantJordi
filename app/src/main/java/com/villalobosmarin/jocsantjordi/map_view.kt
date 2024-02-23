package com.villalobosmarin.jocsantjordi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.villalobosmarin.jocsantjordi.Games.Game02
import com.villalobosmarin.jocsantjordi.Games.Game04

class map_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view)


        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val stars = sharedPrefs.getInt("stars", 0)





        val Buttonlvl1 = findViewById<Button>(R.id.Btnlvl1)
        val Buttonlvl2 = findViewById<Button>(R.id.Btnlvl2)
        val Buttonlvl3 = findViewById<Button>(R.id.Btnlvl3)
        val Buttonlvl4 = findViewById<Button>(R.id.Btnlvl4)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)

        Buttonlvl1.setOnClickListener {
            showGameDialog01("NIVEL 1")
        }

        Buttonlvl2.setOnClickListener {
            // Muestra el diálogo y luego inicia el juego
            showGameDialog02("NIVEL 2")
        }

        Buttonlvl3.setOnClickListener {
            showGameDialog03("NIVEL 3")
        }

        Buttonlvl4.setOnClickListener {
            showGameDialog04("NIVEL 4")
        }

        btnHome.setOnClickListener {
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

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showGameDialog02(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game02, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()



        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val starFilled = sharedPrefs.getBoolean("starFilled", false)


        val starImageView = dialogView.findViewById<ImageView>(R.id.starView)
        if (starFilled) {
            starImageView.setImageResource(R.drawable.ic_star_on)
        } else {
            starImageView.setImageResource(R.drawable.ic_star_off)
        }

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

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showGameDialog04(title: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_game04, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
        val dialog = dialogBuilder.create()

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val starFilled = sharedPrefs.getBoolean("starFilled", false)

        val starImageView = dialogView.findViewById<ImageView>(R.id.reloadImage)
        if (starFilled) {
            starImageView.setImageResource(R.drawable.ic_star_on)
        } else {
            starImageView.setImageResource(R.drawable.ic_star_off)
        }

        dialogView.findViewById<Button>(R.id.playButton).setOnClickListener {
            dialog.dismiss()

            // Inicia la actividad Game04
            val intent = Intent(this@map_view, Game04::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

}

