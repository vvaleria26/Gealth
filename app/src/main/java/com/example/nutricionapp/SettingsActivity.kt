package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class SettingsActivity : AppCompatActivity() {

    private lateinit var logoutButton: Button
    private lateinit var deleteAccountButton: Button
    private lateinit var notificationCheckBox: CheckBox
    private lateinit var termsTextView: TextView
    private lateinit var profileTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Inicializa las vistas
        logoutButton = findViewById(R.id.logoutButton)
        deleteAccountButton = findViewById(R.id.deleteAccountButton)
        notificationCheckBox = findViewById(R.id.notificationCheckBox)
        termsTextView = findViewById(R.id.termsTextView)
        profileTextView = findViewById(R.id.profileTextView)

        // Configurar el botón para cerrar sesión
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Finaliza la actividad de configuración para que el usuario no regrese a ella al presionar "Atrás"
        }

        // Configurar el botón para eliminar cuenta (aquí puedes agregar lógica para eliminar la cuenta)
        deleteAccountButton.setOnClickListener {
            Toast.makeText(this, "Cuenta eliminada (aquí va la lógica)", Toast.LENGTH_SHORT).show()
            // Aquí va la lógica de eliminación de cuenta
        }

        // Configurar el TextView de términos y condiciones
        termsTextView.setOnClickListener {
            // Aquí debes agregar la acción que llevará al usuario a los términos y condiciones
            Toast.makeText(this, "Términos y condiciones", Toast.LENGTH_SHORT).show()
        }

        // Configurar el TextView para modificar el perfil
        profileTextView.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        // Configurar el CheckBox de notificaciones
        notificationCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Lógica para activar las notificaciones
                Toast.makeText(this, "Notificaciones activadas", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica para desactivar las notificaciones
                Toast.makeText(this, "Notificaciones desactivadas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
