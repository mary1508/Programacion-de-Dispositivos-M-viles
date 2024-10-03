/*
Descripción: Fragmento que contiene el RecyclerView para listar los audios.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 03/10/2024
*/
package com.example.ejercicio01depractica5
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaAudiosFragment : Fragment(){

    private lateinit var audioAdapter: AudioAdapter

    // Crear la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_list, container, false)
        // Crear la lista de audios
        val audios = listOf(
            Audio("How Deep Is Your Love", R.drawable.image_audio1, "3:32", R.raw.videoplayback),
            Audio("Idilio", R.drawable.image_audio2, "4:21", R.raw.idilio),
            Audio("Sad Girlz Luv Money", R.drawable.image_audio3, "2:45", R.raw.luv_money),
            Audio("ALIBI", R.drawable.image_audio4, "3:12", R.raw.rosa_que_linda_eres),
            Audio("Virgen", R.drawable.image_audio5, "4:08", R.raw.virgen)
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_audios)
        recyclerView.layoutManager = LinearLayoutManager(context)
        audioAdapter = AudioAdapter(audios) { audio ->
            val reproductorFragment = ReproductorFragment.newInstance(audio.nombre, audio.imagenResId, audio.audioResId)
            parentFragmentManager.beginTransaction()
                ?.replace(R.id.fragment_container, reproductorFragment)
                ?.addToBackStack(null)
                ?.commit()
        } // Configurar adaptador
        recyclerView.adapter = audioAdapter

        return view
    }

}
