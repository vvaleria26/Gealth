package com.example.nutricionapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R
import kotlin.random.Random

class RecomendacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)

        // Configuración de botones
        findViewById<Button>(R.id.homeButton).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.diagnosticButton).setOnClickListener {
            val intent = Intent(this, DiagnosticActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }


        // video
        val videoView = findViewById<VideoView>(R.id.exerciseVideo)
        val videos: List<String> = listOf(
            "android.resource://" + packageName + "/" + R.raw.ejercicios1sbp,
            "android.resource://" + packageName + "/" + R.raw.ejercicios2,
            "android.resource://" + packageName + "/" + R.raw.ejercicios3,
            "android.resource://" + packageName + "/" + R.raw.ejercicios4,
        )
        val idxVideo = Random.nextInt(0, videos.size-1)

        val uri = Uri.parse(videos[idxVideo])
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(this, "Error al cargar el video", Toast.LENGTH_SHORT).show()
            true
        }
        val playButton = findViewById<Button>(R.id.playPauseButton)
        playButton.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
        }
        val forwardButton = findViewById<Button>(R.id.forwardButton)
        forwardButton.setOnClickListener {
            videoView.seekTo(videoView.currentPosition + 5000)
        }
        val rewindButton = findViewById<Button>(R.id.rewindButton)
        rewindButton.setOnClickListener {
            videoView.seekTo(videoView.currentPosition - 5000)
        }
    }
}
