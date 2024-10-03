package com.example.ejercicio2_practica4

/*
Descripción: Fragmento para la selección de canciones en un Spinner.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 02/10/2024
*/

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment

class SeleccionCancionFragment : Fragment() {

    private var listener: OnCancionSeleccionadaListener? = null

    interface OnCancionSeleccionadaListener {
        fun onCancionSeleccionada(cancionIndex: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCancionSeleccionadaListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnCancionSeleccionadaListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_cancion, container, false)

        val spinner: Spinner = view.findViewById(R.id.spinner_canciones)
        val imgCancion: ImageView = view.findViewById(R.id.img_cancion)

        // Canciones desde strings.xml
        val canciones = arrayOf(
            getString(R.string.cancion1),
            getString(R.string.cancion2),
            getString(R.string.cancion3),
            getString(R.string.cancion4),
            getString(R.string.cancion5)
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, canciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Cambiar la imagen según selección
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val imagenResId = when (position) {
                    0 -> R.drawable.image_audio1
                    1 -> R.drawable.image_audio2
                    2 -> R.drawable.image_audio3
                    3 -> R.drawable.image_audio4
                    4 -> R.drawable.image_audio5
                    else -> R.drawable.image_audio1
                }
                imgCancion.setImageResource(imagenResId)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                imgCancion.setImageResource(R.drawable.image_audio1)
            }
        }

        val btnSeleccionar: Button = view.findViewById(R.id.btn_seleccionar)
        btnSeleccionar.setOnClickListener {
            listener?.onCancionSeleccionada(spinner.selectedItemPosition)
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
