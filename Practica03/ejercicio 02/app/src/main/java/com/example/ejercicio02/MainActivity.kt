package com.example.ejercicio02

/*
Descripción: Actividad principal que permite seleccionar un audio de un Spinner, mostrar su imagen y pasar a la actividad de reproducción.
Autor: Marycielo Bedoya Pinto
Fecha creación: 28/09/2024
Fecha última modificación: 28/09/2024
*/

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias a los elementos de la UI
        val spinner: Spinner = findViewById(R.id.spinner_audios)
        val imgAudio: ImageView = findViewById(R.id.img_audio)
        val btnSeleccionar: Button = findViewById(R.id.btn_seleccionar)

        // Nombres de los audios desde strings.xml
        val audios = arrayOf(
            getString(R.string.audio1),
            getString(R.string.audio2),
            getString(R.string.audio3),
            getString(R.string.audio4),
            getString(R.string.audio5)
        )

        // Imágenes correspondientes a cada audio
        val audioImages = arrayOf(
            R.drawable.image_audio1, // Imagen de How Deep Is Your Love
            R.drawable.image_audio2, // Imagen de Idilio
            R.drawable.image_audio3, // Imagen de Sad Girlz Luv Money
            R.drawable.image_audio4, // Imagen de ALIBI
            R.drawable.image_audio5  // Imagen de Virgen
        )

        // Configurar adaptador para el Spinner con los nombres de las canciones
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audios)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Listener para actualizar la imagen cuando se selecciona un audio en el Spinner
        spinner.setOnItemSelectedListener { _, _, position, _ ->
            imgAudio.setImageResource(audioImages[position])
        }

        // Listener para el botón Seleccionar
        btnSeleccionar.setOnClickListener {
            val audioSeleccionado = spinner.selectedItemPosition

            // Crear intent para pasar a la actividad de reproducción con el índice del audio seleccionado
            val intent = Intent(this, ReproductorActivity::class.java)
            intent.putExtra("audio_index", audioSeleccionado)
            startActivity(intent)
        }
    }
}
