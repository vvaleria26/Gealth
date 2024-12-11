package com.example.nutricionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gealth.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val diagnosticButton = findViewById<Button>(R.id.diagnosticButton)
        val recommendationsButton = findViewById<Button>(R.id.recommendationsButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val homeButton = findViewById<Button>(R.id.homeButton)
        val recipesRecyclerView = findViewById<RecyclerView>(R.id.recipesRecyclerView)

        // Configurar RecyclerView
        val recipes = listOf(
            Recipe("Spaghetti Carbonara", R.drawable.recipe1),
            Recipe("Grilled Salmon", R.drawable.recipe2),
            Recipe("Margherita Pizza", R.drawable.recipe3),
            Recipe("Chicken Caesar Salad", R.drawable.recipe4),
            Recipe("Chocolate Lava Cake", R.drawable.recipe5)
        )
        val adapter = RecipeAdapter(recipes) { recipe ->
            RecipePopupDialog.show(this, recipe) // Mostrar un popup con la receta seleccionada
        }
        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        recipesRecyclerView.adapter = adapter


        // Navegación
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Actividad principal
            startActivity(intent)
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
