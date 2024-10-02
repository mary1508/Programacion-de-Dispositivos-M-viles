package com.example.ejercicio01practica4

/*
Descripción: Actividad principal que coordina los fragmentos para seleccionar y mostrar imágenes.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 02/10/2024
*/
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), SeleccionImagenFragment.OnImagenSeleccionadaListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val seleccionImagenFragment = SeleccionImagenFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, seleccionImagenFragment)
                .commit()
        }
    }

    override fun onImagenSeleccionada(imagenIndex: Int) {
        val mostrarImagenFragment = MostrarImagenFragment.newInstance(imagenIndex)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, mostrarImagenFragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}
