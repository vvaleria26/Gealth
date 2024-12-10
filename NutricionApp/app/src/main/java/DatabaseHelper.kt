package com.example.nutricionapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // Crear tabla con columna email
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT, " +
                "$COLUMN_PASSWORD TEXT, " +
                "$COLUMN_EMAIL TEXT)"  // Nueva columna para el correo electrónico
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Método para agregar un nuevo usuario (incluyendo email)
    fun addUser(username: String, password: String, email: String) {
        val db = this.writableDatabase
        val values = ContentValues()

        // Agregar valores al ContentValues
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_PASSWORD, password)
        values.put(COLUMN_EMAIL, email)  // Agregar el email

        // Insertar el usuario en la tabla
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // Método para validar un usuario con el correo y la contraseña
    fun validateUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(username, password))

        val userExists = cursor.count > 0
        cursor.close()
        db.close()

        return userExists
    }

    companion object {
        const val DATABASE_NAME = "usuarios.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "usuarios"
        const val COLUMN_ID = "id_user"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_EMAIL = "email"  // Nueva columna
    }
}
