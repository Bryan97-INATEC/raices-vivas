package com.base.app_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Relatos_Fragment : Fragment() {
    val items = listOf(
        ContentItem(
            R.drawable.c2,
            "La Güegüense o Macho Ratón",
            "Obra teatral bailada que mezcla humor, sátira y música. Representa la resistencia indígena frente a los españoles. \n Diriamba (Carazo), fiestas de San Sebastián."
        ),
        ContentItem(
            R.drawable.c1,
            "La Carreta Nagua",
            "Carreta fantasmagórica que se escucha en la madrugada sin bueyes ni cochero, recogiendo almas en pena. \n Presente en todo el país, más fuerte en el Pacífico y Norte."
        ),
        ContentItem(
            R.drawable.c2,
            "La Cumbia del Zenzontle",
            "Relato simbólico sobre el ave zenzontle, que canta con muchos tonos y representa la diversidad cultural.\n Región del Pacífico de Nicaragua."
        ),
        ContentItem(
            R.drawable.c3,
            "El Cadejo Negro",
            "Espíritu en forma de perro oscuro, de ojos rojos y cadenas, que confunde y arrastra a los viajeros nocturnos. \n Zonas rurales del Norte y Occidente de Nicaragua."
        ),
        ContentItem(
            R.drawable.c4,
            "La novia del Xolotlán",
            "Historia de una joven que esperaba eternamente a su amado en la orilla del lago Xolotlán. \n Managua, orillas del lago Xolotlán."
        ),
        ContentItem(
            R.drawable.c5,
            "El origen de la Tortuga Paslama",
            "Leyenda de una princesa convertida en tortuga para proteger a sus hijos y al mar.\n Costa Caribe y litoral Pacífico (Chacocente y La Flor)."
        ),
        ContentItem(
            R.drawable.c7,
            "La Novia de Tola",
            "Joven que murió antes de casarse y aparece vestida de novia en los caminos, asustando viajeros.\n Tola, Rivas."
        ),
        ContentItem(
            R.drawable.c8,
            "La Chancha Bruja",
            "Bruja que toma forma de una chancha enorme con ojos brillantes; quien la sigue descubre al día siguiente a una mujer herida. \n Pueblos del Pacífico y Norte de Nicaragua."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ContentAdapter(items, "relato")
        return view
    }
}