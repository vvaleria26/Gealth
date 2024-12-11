package com.example.nutricionapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.gealth.R

object RecipePopupDialog {
    fun show(context: Context, recipe: Recipe) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_recipe, null)
        val recipeTitle = dialogView.findViewById<TextView>(R.id.recipeTitleTextView)
        val stepsViewPager = dialogView.findViewById<ViewPager2>(R.id.stepsViewPager)
        val closeButton = dialogView.findViewById<Button>(R.id.closeButton)

        recipeTitle.text = recipe.name
        val steps = getRecipeSteps(recipe.name)
        val adapter = StepsAdapter(steps)
        stepsViewPager.adapter = adapter

        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun getRecipeSteps(name: String): List<String> {
        return when (name) {
            "Spaghetti Carbonara" -> listOf(
                "Cocina los spaghetti en agua con sal hasta que estén al dente.",
                "Fríe la panceta hasta que esté crujiente.",
                "Bate los huevos con queso parmesano.",
                "Mezcla los spaghetti calientes con la panceta y la mezcla de huevos.",
                "Sirve con perejil y pimienta molida."
            )
            "Grilled Salmon" -> listOf(
                "Marina el salmón con jugo de limón y especias.",
                "Asa los espárragos con aceite y sal.",
                "Cocina el salmón en una parrilla caliente durante 4-5 minutos por lado.",
                "Sirve con espárragos y rodajas de limón."
            )
            "Margherita Pizza" -> listOf(
                "Extiende la masa de pizza sobre una bandeja.",
                "Unta la masa con salsa de tomate.",
                "Añade mozzarella fresca y hojas de albahaca.",
                "Hornea a 220°C hasta que la masa esté dorada.",
                "Sirve caliente."
            )
            "Chicken Caesar Salad" -> listOf(
                "Lava y corta la lechuga romana.",
                "Fríe los crutones hasta que estén dorados.",
                "Cocina y corta el pollo en tiras.",
                "Mezcla la lechuga con el aderezo César, el pollo y los crutones.",
                "Espolvorea queso parmesano por encima."
            )
            "Chocolate Lava Cake" -> listOf(
                "Derrite el chocolate con mantequilla a baño maría.",
                "Bate los huevos con azúcar hasta que estén espumosos.",
                "Añade el chocolate derretido y la harina tamizada.",
                "Llena los moldes y hornea por 10 minutos a 200°C.",
                "Sirve caliente con helado y frutas."
            )
            else -> listOf("Receta no disponible.")
        }
    }
}