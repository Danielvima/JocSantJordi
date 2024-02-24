package com.villalobosmarin.jocsantjordi.bookReader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.villalobosmarin.jocsantjordi.R
import com.villalobosmarin.jocsantjordi.map_view

class BookReader : AppCompatActivity() {

    private lateinit var layouts: Array<View>
    private var currentLayoutIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_reader)


//cositas
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, map_view::class.java)
            startActivity(intent)
        }
        // Inicializar array con los layouts
        layouts = arrayOf(
            findViewById(R.id.ll1),
            findViewById(R.id.ll2),
            findViewById(R.id.ll3),
            findViewById(R.id.ll4),
            findViewById(R.id.ll5),
            findViewById(R.id.ll6),
            findViewById(R.id.ll7),
            findViewById(R.id.ll8),
            findViewById(R.id.ll9),
            findViewById(R.id.ll10),
            findViewById(R.id.ll11),


            // Agrega aquí todos los LinearLayout que necesitas controlar
        )

        // Mostrar el primer layout, ocultar los demás
        showLayout(currentLayoutIndex)

        // Configurar listeners para los botones de flecha
        findViewById<Button>(R.id.prevBtn).setOnClickListener { showPreviousLayout() }
        findViewById<Button>(R.id.avBtn).setOnClickListener { showNextLayout() }
    }

    private fun showLayout(index: Int) {
        for (i in layouts.indices) {
            if (i == index) {
                layouts[i].visibility = View.VISIBLE
            } else {
                layouts[i].visibility = View.GONE
            }
        }
    }

    private fun showNextLayout() {
        if (currentLayoutIndex < layouts.size - 1) {
            currentLayoutIndex++
            showLayout(currentLayoutIndex)
        }
    }

    private fun showPreviousLayout() {
        if (currentLayoutIndex > 0) {
            currentLayoutIndex--
            showLayout(currentLayoutIndex)
        }
    }
}
