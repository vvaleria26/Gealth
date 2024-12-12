package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile) // Usaremos un layout que crea el formulario para editar el perfil
        // Navegación
        val diagnosticButton = findViewById<Button>(R.id.diagnosticButton)
        val recommendationsButton = findViewById<Button>(R.id.recommendationsButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java) // Actividad principal
        }
        diagnosticButton.setOnClickListener {
            val intent = Intent(this, DiagnosticActivity::class.java) // Actividad de diagnóstico
            startActivity(intent)
        }
        recommendationsButton.setOnClickListener {
            val intent = Intent(this, RecomendacionesActivity::class.java) // Actividad de recomendaciones
            startActivity(intent)
        }
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java) // Actividad de configuración
            startActivity(intent)
        }
    }
}
