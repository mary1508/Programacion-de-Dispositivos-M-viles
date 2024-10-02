package com.example.ejercicio01practica4

/*
Descripción: Fragmento para la selección de imágenes en un spinner.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class SeleccionImagenFragment : Fragment() {

    private var listener: OnImagenSeleccionadaListener? = null
    private lateinit var nextButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_imagen, container, false)

        val spinner: Spinner = view.findViewById(R.id.spinner_imagenes)

        // Nombres de las imágenes desde strings.xml
        val imagenes = arrayOf(
            getString(R.string.image1),
            getString(R.string.image2),
            getString(R.string.image3)
        )

        // Adaptador para el spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, imagenes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        nextButton.setOnClickListener {
            val selectedImage = spinner.selectedItemPosition
            listener?.onImagenSeleccionada(selectedImage)
        }

        return view
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImagenSeleccionadaListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnImagenSeleccionadaListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnImagenSeleccionadaListener {
        fun onImagenSeleccionada(imagenIndex: Int)
    }
}
