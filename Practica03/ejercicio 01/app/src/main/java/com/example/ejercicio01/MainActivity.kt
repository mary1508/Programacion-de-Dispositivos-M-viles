package com.example.ejercicio01

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

// Descripción: Actividad principal que permite seleccionar una imagen y navegar a la siguiente actividad.
// Autor: Marycielo Bedoya Pinto
// Fecha de creación: 2024-09-20
// Fecha de última modificación: 2024-09-20

class MainActivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var selectedImage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner_images)
        val images = arrayOf("Image1", "Image2", "Image3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, images)
        spinner.adapter = adapter

        // Restaurar la selección del spinner si esta disponible
        selectedImage = savedInstanceState?.getString("selectedImage") ?: images[0]

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("selectedImage", spinner.selectedItem.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("selectedImage", spinner.selectedItem.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selectedImage = savedInstanceState.getString("selectedImage") ?: "Image1"
        spinner.setSelection((spinner.adapter as ArrayAdapter<String>).getPosition(selectedImage))
    }
}
