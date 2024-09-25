/* Descripción: Segunda actividad que muestra la imagen seleccionada en la primera actividad
 además de un botón para volver a la primera actividad.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha de creación :23/09/2024
Fecha de última modificación: 25/09/2024*/

package com.example.ejercicio01

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView = findViewById(R.id.image_view)
        backButton = findViewById(R.id.btn_back)

        // Recibir la posición de la imagen seleccionada desde la primera actividad
        val selectedImage = intent.getIntExtra("selectedImage", 0)

        // Mapeo de las imágenes en drawable
        val imageResIds = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        // Mostrar la imagen seleccionada en el ImageView
        imageView.setImageResource(imageResIds[selectedImage])

        // Botón para volver a la primera actividad
        backButton.setOnClickListener {
            finish() // Termina la actividad actual y vuelve a la anterior
        }
    }
}
