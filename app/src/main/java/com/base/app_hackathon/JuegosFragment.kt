package com.base.app_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JuegosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JuegosAdapter
    private val juegos = mutableListOf<JuegoItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_juegos, container, false)
        recyclerView = view.findViewById(R.id.rvJuegos)
        recyclerView.layoutManager = LinearLayoutManager(context)

        cargarJuegos()

        adapter = JuegosAdapter(juegos) { juego ->
            when(juego.titulo){
                "Quiz de Identidad" -> abrirQuizIdentidad()
                "Identificación de Imágenes" -> abrirIdentificacion()
                "Juego de Memoria" -> abrirMemoria()
                "Completa la Frase" -> abrirCompletaFrase()
                "Verdadero o Falso" -> abrirVerdaderoFalso()
            }
        }

        recyclerView.adapter = adapter

        return view
    }

    private fun cargarJuegos() {
        juegos.add(JuegoItem("Quiz de Identidad", "Responde preguntas sobre historia y tradiciones de Nicaragua."))
        juegos.add(JuegoItem("Identificación de Imágenes", "Identifica símbolos patrios, platos típicos y bailes."))
        juegos.add(JuegoItem("Juego de Memoria", "Empareja imágenes de la cultura nicaragüense."))
        juegos.add(JuegoItem("Completa la Frase", "Llena las palabras faltantes de frases sobre valores patrios."))
        juegos.add(JuegoItem("Verdadero o Falso", "Adivina si las afirmaciones sobre Nicaragua son correctas."))
    }

    // Funciones para abrir cada juego (a implementar)
    private fun abrirQuizIdentidad(){ /* Abrir fragmento o dialogo del quiz */ }
    private fun abrirIdentificacion(){ /* Abrir fragmento de imágenes */ }
    private fun abrirMemoria(){ /* Abrir juego de memoria */ }
    private fun abrirCompletaFrase(){ /* Abrir juego de completar frases */ }
    private fun abrirVerdaderoFalso(){ /* Abrir juego verdadero/falso */ }
}