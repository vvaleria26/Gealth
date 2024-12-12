package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class RegistroActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        dbHelper = DatabaseHelper(this)  // Inicializamos el helper de la base de datos
        usernameEditText = findViewById(R.id.usernameEditText)
        emailEditText = findViewById(R.id.emailEditText)  // Obtenemos el campo de email
        passwordEditText = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()  // Obtenemos el email
            val password = passwordEditText.text.toString()

            // Verificamos que los campos no estén vacíos
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Si todo está bien, agregamos el usuario
                dbHelper.addUser(username, password, email)
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()

                // Regresar al LoginActivity después de registrar
                finish()  // Cierra la actividad de registro y vuelve a la pantalla de login
            } else {
                // Si alguno de los campos está vacío
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        val volverButton = findViewById<Button>(R.id.volverButton)

        volverButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java) // Actividad principal
        }
    }
}
