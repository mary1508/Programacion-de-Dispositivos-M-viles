package com.example.ejercicio01depractica5

/*
Descripción: Fragmento para controlar la reproducción de un audio.
Autor: Marycielo Guadalupe Bedoya Pinto
Fecha creación:02/10/2024
Fecha última modificación: 03/10/2024
*/
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReproductorFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var seekBar: SeekBar
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    companion object {
        private const val ARG_AUDIO = "audio"
        private const val ARG_NOMBRE = "nombre"
        private const val ARG_IMAGEN = "imagen"

        fun newInstance(nombre: String, imagenResId: Int, audioResId: Int): ReproductorFragment {
            val fragment = ReproductorFragment()
            val args = Bundle()
            args.putString(ARG_NOMBRE, nombre)
            args.putInt(ARG_IMAGEN, imagenResId)
            args.putInt(ARG_AUDIO, audioResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio_player, container, false)

        val imgAudio: ImageView = view.findViewById(R.id.img_audio)
        val txtNombre: TextView = view.findViewById(R.id.txt_audio_name)
        val btnPlay: Button = view.findViewById(R.id.btn_reproducir)
        val btnPause: Button = view.findViewById(R.id.btn_pausar)
        val btnStop: Button = view.findViewById(R.id.btn_detener)
        seekBar = view.findViewById(R.id.seekBar)

        val audioName = arguments?.getString(ARG_NOMBRE) ?: ""
        val imagenResId = arguments?.getInt(ARG_IMAGEN) ?: 0
        val audioResId = arguments?.getInt(ARG_AUDIO) ?: 0

        txtNombre.text = audioName
        imgAudio.setImageResource(imagenResId)

        mediaPlayer = MediaPlayer.create(requireContext(), audioResId)
        seekBar.max = mediaPlayer.duration

        handler = Handler()

        // Actualizar el progreso de la SeekBar cada segundo
        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }

        btnPlay.setOnClickListener {
            mediaPlayer.start()
            handler.postDelayed(runnable, 0)
        }

        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                handler.removeCallbacks(runnable)
            }
        }

        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()
                seekBar.progress = 0
                handler.removeCallbacks(runnable)
            }
        }

        // Permitir que el usuario controle la posición de la reproducción con la SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación aquí
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación aquí
            }
        })

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        handler.removeCallbacks(runnable)  // Detener la actualización de la SeekBar al destruir el fragmento
    }
}
