/*
Descripción: Fragmento que contiene el RecyclerView para listar los audios.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaAudiosFragment : Fragment(), AudioAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var audioAdapter: AudioAdapter

    // Crear la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista_audios, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)  // Configurar layout vertical

        // Crear la lista de audios
        val audios = listOf(
            Audio("How Deep Is Your Love", R.drawable.imagen1, "3:32", R.raw.audio1),
            Audio("Idilio", R.drawable.imagen2, "4:21", R.raw.audio2),
            Audio("Sad Girlz Luv Money", R.drawable.imagen3, "2:45", R.raw.audio3),
            Audio("ALIBI", R.drawable.imagen4, "3:12", R.raw.audio4),
            Audio("Virgen", R.drawable.imagen5, "4:08", R.raw.audio5)
        )

        audioAdapter = AudioAdapter(audios, this)  // Configurar adaptador
        recyclerView.adapter = audioAdapter

        return view
    }

    // Manejar la selección de un ítem
    override fun onItemClick(audio: Audio) {
        val reproductorFragment = ReproductorFragment.newInstance(audio)

        // Cambiar al fragmento de reproducción al hacer clic en un audio
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, reproductorFragment)
            .addToBackStack(null)
            .commit()
    }
}
