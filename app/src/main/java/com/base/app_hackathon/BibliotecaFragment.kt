package com.base.app_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BibliotecaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BibliotecaAdapter
    private val items = mutableListOf<BibliotecaItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_biblioteca, container, false)
        recyclerView = view.findViewById(R.id.rvBiblioteca)
        recyclerView.layoutManager = LinearLayoutManager(context)

        cargarDatos()

        adapter = BibliotecaAdapter(items)
        recyclerView.adapter = adapter

        return view
    }

    private fun cargarDatos() {
        items.add(BibliotecaItem("Nacatamal", "Receta tradicional nicaragüense de masa de maíz con carne, envuelta en hoja de plátano."))
        items.add(BibliotecaItem("La Purísima", "Celebración religiosa con cantos, rezos y altares dedicados a la Virgen María."))
        items.add(BibliotecaItem("Indio Viejo", "Plato típico hecho a base de carne de res, maíz y verduras."))
        items.add(BibliotecaItem("El Güegüense", "Obra teatral mestiza con burlas satíricas a la autoridad colonial."))
        items.add(BibliotecaItem("Fiestas Patronales", "Ferias y festividades en honor a los santos patronos de cada municipio."))
    }
}