package com.example.ejercicio02

/*
Descripción: Actividad para reproducir, pausar y detener el audio seleccionado, y mostrar su imagen asociada.
Autor: Marycielo Bedoya Pinto
Fecha creación: 28/09/24
Fecha última modificación: 28/09/24
*/

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReproductorActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor)

        // Obtener el índice del audio seleccionado de la actividad anterior
        val audioIndex = intent.getIntExtra("audio_index", 0)

        // Obtener la referencia a los elementos UI
        val textAudio: TextView = findViewById(R.id.txt_audio)
        val imgAudio: ImageView = findViewById(R.id.img_audio)

        // Array de nombres de audios y las imágenes asociadas
        val audios = arrayOf(
            getString(R.string.audio1),
            getString(R.string.audio2),
            getString(R.string.audio3),
            getString(R.string.audio4),
            getString(R.string.audio5)
        )

        val audioImages = arrayOf(
            R.drawable.image_audio1, // Imagen para Audio 1
            R.drawable.image_audio2, // Imagen para Audio 2
            R.drawable.image_audio3, // Imagen para Audio 3
            R.drawable.image_audio4, // Imagen para Audio 4
            R.drawable.image_audio5  // Imagen para Audio 5
        )

        // Mostrar el nombre y la imagen del audio seleccionado
        textAudio.text = audios[audioIndex]
        imgAudio.setImageResource(audioImages[audioIndex])

        // Inicializar el MediaPlayer según el audio seleccionado
        val audioResId = when (audioIndex) {
            0 -> R.raw.videoplayback
            1 -> R.raw.idilio
            2 -> R.raw.luv_money
            3 -> R.raw.rosa_que_linda_eres
            4 -> R.raw.virgen
            else -> R.raw.videoplayback
        }
        mediaPlayer = MediaPlayer.create(this, audioResId)

        // Botones para reproducir, pausar y detener la reproducción
        val btnPlay: Button = findViewById(R.id.btn_reproducir)
        val btnPause: Button = findViewById(R.id.btn_pausar)
        val btnStop: Button = findViewById(R.id.btn_detener)

        btnPlay.setText(R.string.btn_reproducir)
        btnPause.setText(R.string.btn_pausar)
        btnStop.setText(R.string.btn_detener)

        btnPlay.setOnClickListener {
            mediaPlayer.start()
        }

        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()  // Prepara el MediaPlayer para ser reutilizado
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
