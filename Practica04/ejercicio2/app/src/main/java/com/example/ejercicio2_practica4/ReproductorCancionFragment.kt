package com.example.ejercicio2_practica4

/*
Descripción: Fragmento para reproducir la canción seleccionada con controles y SeekBar.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 02/10/2024
*/


import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReproductorCancionFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private var isPlaying = false
    private lateinit var songName: TextView
    private var userIsSeeking = false

    companion object {
        private const val ARG_CANCION_INDEX = "cancion_index"

        fun newInstance(cancionIndex: Int): ReproductorCancionFragment {
            val fragment = ReproductorCancionFragment()
            val args = Bundle()
            args.putInt(ARG_CANCION_INDEX, cancionIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reproductor_cancion, container, false)
        songName = view.findViewById(R.id.audio_name)
        val imgCancion: ImageView = view.findViewById(R.id.img_cancion)
        val btnReproducir: Button = view.findViewById(R.id.btn_reproducir)
        val btnPausar: Button = view.findViewById(R.id.btn_pausar)
        val btnDetener: Button = view.findViewById(R.id.btn_detener)
        seekBar = view.findViewById(R.id.seekbar)
        val btnVolver:Button = view.findViewById(R.id.btn_volver)

        val cancionIndex = arguments?.getInt(ARG_CANCION_INDEX) ?: 0

        // Establecer la imagen de la canción seleccionada
        val imagenResId = when (cancionIndex) {
            0 -> {
                songName.text = getString(R.string.cancion1)
                R.drawable.image_audio1
            }
            1 -> {
                songName.text = getString(R.string.cancion2)
                R.drawable.image_audio2
            }
            2 -> {
                songName.text = getString(R.string.cancion3)
                R.drawable.image_audio3
            }
            3 -> {
                songName.text = getString(R.string.cancion4)
                R.drawable.image_audio4
            }
            4 -> {
                songName.text = getString(R.string.cancion5)
                R.drawable.image_audio5
            }
            else -> R.drawable.image_audio1
        }
        imgCancion.setImageResource(imagenResId)

        // Inicializar MediaPlayer con un archivo de audio según la canción seleccionada
        val audioResId = when (cancionIndex) {
            0 -> R.raw.videoplayback
            1 -> R.raw.idilio
            2 -> R.raw.luv_money
            3 -> R.raw.rosa_que_linda_eres
            4 -> R.raw.virgen
            else -> 0
        }

        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)

        // Configurar los botones
        btnReproducir.setOnClickListener {
            mediaPlayer?.start()
            isPlaying = true
            updateSeekBar()
        }

        btnPausar.setOnClickListener {
            if (isPlaying) {
                mediaPlayer?.pause()
                isPlaying = false
            }
        }

        btnDetener.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare()
            isPlaying = false
            seekBar.progress = 0
        }

        btnVolver.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
// Configurar el SeekBar para que el usuario pueda moverlo
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                userIsSeeking = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                userIsSeeking = false
            }
        })
        return view
    }

    // Actualizar la SeekBar mientras se reproduce la canción
    private fun updateSeekBar() {
        seekBar.max = mediaPlayer?.duration ?: 0
        val update = object : Runnable {
            override fun run() {
                if (mediaPlayer != null && isPlaying) {
                    seekBar.progress = mediaPlayer?.currentPosition ?: 0
                    seekBar.postDelayed(this, 1000)
                }
            }
        }
        seekBar.post(update)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
