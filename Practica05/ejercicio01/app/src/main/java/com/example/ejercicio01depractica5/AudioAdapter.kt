package com.example.ejercicio01depractica5

/*
Descripción: Adaptador para mostrar la lista de audios en un RecyclerView.
Autor: Marycielo Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 03/10/2024
*/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AudioAdapter(
    private val audios: List<Audio>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(audio: Audio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audios[position]
        holder.bind(audio)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(audio)
        }
    }

    override fun getItemCount(): Int = audios.size

    class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAudio: ImageView = itemView.findViewById(R.id.img_audio)
        private val txtNombre: TextView = itemView.findViewById(R.id.txt_nombre_audio)
        private val txtDuracion: TextView = itemView.findViewById(R.id.txt_duracion_audio)

        fun bind(audio: Audio) {
            imgAudio.setImageResource(audio.imagenResId)
            txtNombre.text = audio.nombre
            txtDuracion.text = audio.duracion
        }
    }
}
