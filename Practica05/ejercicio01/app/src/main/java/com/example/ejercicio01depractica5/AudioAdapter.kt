/*
Descripción: Adaptador para mostrar la lista de audios en un RecyclerView.
Autor: [Tu Nombre]
Fecha creación: [Fecha de Creación]
Fecha última modificación: [Fecha de Modificación]
*/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador que recibe la lista de audios y el listener para el clic en los elementos
class AudioAdapter(
    private val audios: List<Audio>,                         // Lista de audios
    private val itemClickListener: OnItemClickListener       // Listener para manejar la selección de un audio
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    // Interfaz que define la acción cuando un ítem es seleccionado
    interface OnItemClickListener {
        fun onItemClick(audio: Audio)
    }

    // Inflar el layout para cada ítem del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return AudioViewHolder(view)
    }

    // Enlazar los datos de un audio a la vista
    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audios[position]
        holder.bind(audio)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(audio)  // Notificar al listener que se hizo clic en el audio
        }
    }

    // Obtener el número total de ítems
    override fun getItemCount(): Int = audios.size

    // ViewHolder que contiene las vistas para cada ítem
    class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAudio: ImageView = itemView.findViewById(R.id.img_audio)
        private val txtNombre: TextView = itemView.findViewById(R.id.txt_nombre_audio)
        private val txtDuracion: TextView = itemView.findViewById(R.id.txt_duracion_audio)

        // Vincular el audio a las vistas
        fun bind(audio: Audio) {
            imgAudio.setImageResource(audio.imagenResId)
            txtNombre.text = audio.nombre
            txtDuracion.text = audio.duracion
        }
    }
}
