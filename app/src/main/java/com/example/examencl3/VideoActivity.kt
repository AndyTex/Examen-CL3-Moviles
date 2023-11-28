package com.example.examencl3

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {

    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById(R.id.videoView) // Asegúrate de que el identificador sea correcto
        val url = intent.getStringExtra("Url")
        if (!url.isNullOrEmpty()) {
            val uri: Uri = Uri.parse(url)
            videoView.setVideoURI(uri)
            val mediaController = MediaController(this)
            videoView.setMediaController(mediaController)
            mediaController.setAnchorView(videoView)

            videoView.setOnErrorListener { _, _, _ ->
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "URL no encontrado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
