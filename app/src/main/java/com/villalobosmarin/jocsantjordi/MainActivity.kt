package com.villalobosmarin.jocsantjordi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnJugar = findViewById<Button>(R.id.btnJugar)
        BtnJugar.setOnClickListener {
            val intent = Intent(this,map_view::class.java)
            startActivity(intent)
        }
//hola adiossss
    }

}