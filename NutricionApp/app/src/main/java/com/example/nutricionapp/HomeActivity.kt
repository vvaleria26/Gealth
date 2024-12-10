package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val diagnosticButton = findViewById<Button>(R.id.diagnosticButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val recommendationsButton = findViewById<Button>(R.id.recommendationsButton)

        diagnosticButton.setOnClickListener {
            val intent = Intent(this, DiagnosticActivity::class.java)
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
           startActivity(intent)
        }
        recommendationsButton.setOnClickListener {
            val intent = Intent(this, RecomendacionesActivity::class.java)
           startActivity(intent)
        }
    }
}
