package com.example.ejercicio01practica4
/*
Descripción: Fragmento para mostrar la imagen seleccionada.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación:02/10/2024
Fecha última modificación: 02/10/2024
*/
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class MostrarImagenFragment : Fragment() {
    private lateinit var backButton: Button

    companion object {
        private const val ARG_IMAGEN_INDEX = "imagen_index"

        fun newInstance(imagenIndex: Int): MostrarImagenFragment {
            val fragment = MostrarImagenFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGEN_INDEX, imagenIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mostrar_imagen, container, false)
        val imgMostrar: ImageView = view.findViewById(R.id.img_imagen)

        val imagenIndex = arguments?.getInt(ARG_IMAGEN_INDEX) ?: 0
        val imagenResId = when (imagenIndex) {
            0 -> R.drawable.image1
            1 -> R.drawable.image2
            2 -> R.drawable.image3
            else -> R.drawable.image1
        }
        backButton.setOnClickListener {
            // Navegar de vuelta al fragmento anterior (FragmentSpinner)
            requireActivity().supportFragmentManager.popBackStack()
        }
        imgMostrar.setImageResource(imagenResId)

        return view
    }
}
