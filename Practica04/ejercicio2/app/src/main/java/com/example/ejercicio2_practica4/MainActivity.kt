package com.example.ejercicio2_practica4

/*
Descripción: Actividad principal que controla los fragments.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 02/10/2024
*/

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SeleccionCancionFragment.OnCancionSeleccionadaListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el fragmento de selección de canción
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SeleccionCancionFragment())
                .commit()
        }
    }

    override fun onCancionSeleccionada(cancionIndex: Int) {
        // Cambiar al fragmento de reproducción de canción y pasar el índice de la canción seleccionada
        val reproductorFragment = ReproductorCancionFragment.newInstance(cancionIndex)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, reproductorFragment)
            .addToBackStack(null)
            .commit()
    }
}
