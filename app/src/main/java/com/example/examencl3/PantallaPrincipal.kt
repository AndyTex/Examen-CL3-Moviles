package com.example.examencl3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class PantallaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)


        val btnListaVideo = findViewById<Button>(R.id.btnListadevideo)

        btnListaVideo.setOnClickListener {
            val loginScreen = Intent(this, ListaVideo::class.java)
            startActivity(loginScreen)
        }
    }
}
