package com.example.ejercicio01depractica5

/*
Descripción: Fragmento para controlar la reproducción de un audio.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReproductorFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer  // Objeto MediaPlayer para reproducir el audio

    companion object {
        private const val ARG_AUDIO = "audio"  // Clave para pasar el audio seleccionado

        // Método para crear una nueva instancia del fragmento con el audio seleccionado
        fun newInstance(audio: Audio): ReproductorFragment {
            val fragment = ReproductorFragment()
            val args = Bundle()
            args.putParcelable(ARG_AUDIO, audio)  // Pasar el audio como argumento
            fragment.arguments = args
            return fragment
        }
    }

    // Crear la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reproductor, container, false)

        val imgAudio: ImageView = view.findViewById(R.id.img_audio)
        val txtNombre: TextView = view.findViewById(R.id.txt_nombre_audio)
        val btnPlay: Button = view.findViewById(R.id.btn_reproducir)
        val btnPause: Button = view.findViewById(R.id.btn_pausar)
        val btnStop: Button = view.findViewById(R.id.btn_detener)

        // Recuperar el audio seleccionado desde los argumentos
        val audio = arguments?.getParcelable<Audio>(ARG_AUDIO)
        audio?.let {
            imgAudio.setImageResource(it.imagenResId)  // Mostrar la imagen del audio
            txtNombre.text = it.nombre  // Mostrar el nombre del audio
            mediaPlayer = MediaPlayer.create(context, it.audioResId)  // Crear MediaPlayer con el audio seleccionado
        }

        // Iniciar reproducción del audio
        btnPlay.setOnClickListener {
            mediaPlayer.start()
        }

        // Pausar la reproducción del audio
        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        // Detener la reproducción del audio y resetear el estado
        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()  // Preparar de nuevo para poder reproducir después
            }
        }

        return view
    }

    // Liberar los recursos del MediaPlayer al destruir el fragmento
    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
