package com.base.app_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalendarioFragment : Fragment() {
    private lateinit var calendarView: CalendarView
    private lateinit var tvEvento: TextView

    // Lista de eventos culturales
    private val eventos = mapOf(
        "2025-02-02" to "Día de la Virgen de La Candelaria",
        "2025-03-10" to "Festival de San José de los Remates",
        "2025-07-01" to "Fiestas de Santo Domingo de Guzmán",
        "2025-12-07" to "Purísima / Tradición mariana",
        "2025-09-15" to "Día de la Independencia de Nicaragua"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendario, container, false)

       /* calendarView = view.findViewById(R.id.calendarView)
        tvEvento = view.findViewById(R.id.tvEvento)*/

        // Detectar cambio de fecha
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val fecha = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
            val evento = eventos[fecha]
            if (evento != null) {
                tvEvento.text = "Evento: $evento"
            } else {
                tvEvento.text = "No hay eventos culturales este día"
            }
        }

        return view
    }
}