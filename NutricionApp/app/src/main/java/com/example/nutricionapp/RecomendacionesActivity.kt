package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.gealth.R
import com.example.nutricionapp.DiagnosticActivity
import com.example.nutricionapp.HomeActivity
import com.example.nutricionapp.SettingsActivity

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

        // Agregar cualquier otra lógica que necesites para la página de recomendaciones
    }
}
