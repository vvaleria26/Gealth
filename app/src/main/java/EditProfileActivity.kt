package com.example.nutricionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gealth.R

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile) // Usaremos un layout que crea el formulario para editar el perfil
    }
}
