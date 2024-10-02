package com.example.ejercicio01practica4

/*
Descripción: Actividad principal que coordina los fragmentos para seleccionar y mostrar imágenes.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
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
