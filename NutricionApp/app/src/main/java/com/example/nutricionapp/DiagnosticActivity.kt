package com.example.nutricionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class DiagnosticActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostico)

        val edadEditText: EditText = findViewById(R.id.edadEditText)
        val pesoEditText: EditText = findViewById(R.id.pesoEditText)
        val alturaEditText: EditText = findViewById(R.id.alturaEditText)
        val actividadSpinner: Spinner = findViewById(R.id.actividadSpinner)
        //val habitosRadioGroup: RadioGroup = findViewById(R.id.habitosRadioGroup)
        val diagnosticButton: Button = findViewById(R.id.diagnosticButton)

        diagnosticButton.setOnClickListener {
            val edad = edadEditText.text.toString().toInt()
            val peso = pesoEditText.text.toString().toDouble()
            val altura = alturaEditText.text.toString().toDouble()
            val actividad = actividadSpinner.selectedItem.toString()
            // val habitos = findViewById<RadioButton>(habitosRadioGroup.checkedRadioButtonId)

            // Aquí iría la lógica para el diagnóstico
            val diagnostico = "Tu diagnóstico es: Necesitas mejorar tu alimentación y hacer más ejercicio."

            Toast.makeText(this, diagnostico, Toast.LENGTH_LONG).show()
        }
    }
}
