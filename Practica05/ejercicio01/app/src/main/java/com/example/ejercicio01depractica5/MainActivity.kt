package com.example.ejercicio01depractica5

/*
Descripción: Actividad principal que gestiona el contenedor de fragmentos y carga la lista de audios.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verificar si esta es la primera vez que se carga la actividad
        if (savedInstanceState == null) {
            // Iniciar la actividad con el fragmento de la lista de audios
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListaAudiosFragment())  // Reemplazar el contenedor con el fragmento
                .commit()
        }
    }

}
