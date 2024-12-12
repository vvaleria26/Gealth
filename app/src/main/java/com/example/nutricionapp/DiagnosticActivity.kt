package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class DiagnosticActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostico)

        val edadEditText: EditText = findViewById(R.id.edadEditText)
        val pesoEditText: EditText = findViewById(R.id.pesoEditText)
        val alturaEditText: EditText = findViewById(R.id.alturaEditText)
        val actividadSpinner: Spinner = findViewById(R.id.actividadSpinner)
        val diagnosticButton: Button = findViewById(R.id.diagnosticoButton)

        // Botones de navegación
        findViewById<Button>(R.id.homeButton).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        findViewById<Button>(R.id.recommendationsButton).setOnClickListener {
            startActivity(Intent(this, RecomendacionesActivity::class.java))
        }

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        diagnosticButton.setOnClickListener {
            val edad = edadEditText.text.toString().toIntOrNull()
            val peso = pesoEditText.text.toString().toDoubleOrNull()
            val altura = alturaEditText.text.toString().toDoubleOrNull()
            val actividad = actividadSpinner.selectedItem.toString()

            if (edad != null && peso != null && altura != null) {
                val imc = peso / ((altura / 100) * (altura / 100))
                val (resultado, recomendaciones) = diagnostico(imc, edad, actividad)

                mostrarPopup(edad, peso, altura, actividad, resultado, recomendaciones)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun diagnostico(imc: Double, edad: Int, actividad: String): Pair<String, String> {
        val resultado = when {
            imc < 18.5 -> "Tienes bajo peso."
            imc in 18.5..24.9 -> "Tienes un peso saludable."
            imc in 25.0..29.9 -> "Tienes sobrepeso."
            else -> "Tienes obesidad."
        }

        val recomendaciones = when (actividad) {
            "Sedentaria" -> "Incrementa tu actividad física y evita alimentos ultraprocesados."
            "Moderada" -> "Mantén una dieta equilibrada y realiza ejercicio 3-4 veces por semana."
            "Intensa" -> "Asegúrate de consumir suficientes calorías y proteínas para tu nivel de actividad."
            else -> "Consulta con un especialista para más recomendaciones."
        }

        return Pair(resultado, recomendaciones)
    }

    private fun mostrarPopup(
        edad: Int,
        peso: Double,
        altura: Double,
        actividad: String,
        resultado: String,
        recomendaciones: String
    ) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_diagnostico_resultado, null)
        val parametersTextView: TextView = dialogView.findViewById(R.id.parametersTextView)
        val resultTextView: TextView = dialogView.findViewById(R.id.resultTextView)
        val recommendationsTextView: TextView = dialogView.findViewById(R.id.recommendationsTextView)

        parametersTextView.text = "Edad: $edad\nPeso: ${peso}kg\nAltura: ${altura}cm\nActividad: $actividad"
        resultTextView.text = resultado
        recommendationsTextView.text = recomendaciones

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.closeButton).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
