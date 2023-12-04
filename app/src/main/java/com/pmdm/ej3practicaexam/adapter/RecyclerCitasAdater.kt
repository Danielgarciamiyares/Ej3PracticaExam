package com.pmdm.ej3practicaexam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pmdm.ej3practicaexam.R
import com.pmdm.ej3practicaexam.databinding.ItemCitaBinding
import com.pmdm.ej3practicaexam.model.Cita

class RecyclerCitasAdater(val datos:List<Cita>):
    RecyclerView.Adapter<RecyclerCitasAdater.CitasViewHolder>(){
        class CitasViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding= ItemCitaBinding.bind(view)

            val textoCitaTextView=binding.tvCitaTexto
            val autorCitaTextView=binding.tvCitaAutor

            fun vincularDatos(cita:Cita){
                textoCitaTextView.text=cita.texto
                autorCitaTextView.text=cita.autor
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitasViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cita, parent, false)
            return CitasViewHolder(view)
        }

        override fun getItemCount(): Int {
            return datos.count()
        }

        override fun onBindViewHolder(holder: CitasViewHolder, position: Int) {
            val message = datos[position]
            holder.vincularDatos(message)
        }
}