package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio01.R
import com.example.ejercicio01.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner_images)
        nextButton = findViewById(R.id.btn_next)

        // Definir los nombres de las imágenes (se toman de strings.xml)
        val imageNames = arrayOf(
            getString(R.string.image1),
            getString(R.string.image2),
            getString(R.string.image3)
        )

        // Configurar el adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Al presionar el botón "Siguiente", se pasa la imagen seleccionada a la segunda actividad
        nextButton.setOnClickListener {
            val selectedImage = spinner.selectedItemPosition
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }

        // Restaurar el estado del spinner si existe una instancia guardada
        if (savedInstanceState != null) {
            spinner.setSelection(savedInstanceState.getInt("spinnerPosition"))
        }
    }

    // Guardar la posición seleccionada del spinner en caso de rotación de pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerPosition", spinner.selectedItemPosition)
    }
}
