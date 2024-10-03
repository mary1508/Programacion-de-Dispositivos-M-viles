/*
Descripción: Adaptador para mostrar la lista de audios en un RecyclerView.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/
package com.example.ejercicio01depractica5
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Adaptador que recibe la lista de audios y el listener para el clic en los elementos
class AudioAdapter(
    private val audios: List<Audio>,
    private val Listener: (Audio) -> Unit
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    // ViewHolder que contiene las vistas para cada ítem
    class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAudio: ImageView = view.findViewById(R.id.img_audio)
        val txtNombre: TextView = view.findViewById(R.id.audio_name)
        val txtDuracion: TextView = view.findViewById(R.id.audio_duration)
    }

    // Inflar el layout para cada ítem del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.audio_item, parent, false)
        return AudioViewHolder(view)
    }

    // Enlazar los datos de un audio a la vista
    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audios[position]
        holder.txtNombre.text = audio.nombre
        holder.txtDuracion.text = audio.duracion
        holder.imgAudio.setImageResource(audio.imagenResId)
        holder.itemView.setOnClickListener {
            Listener(audio)
        }
    }

    // Obtener el número total de ítems
    override fun getItemCount(): Int = audios.size
}

