package com.base.app_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapaFragment : Fragment() {
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mapa, container, false)

        mapView = view.findViewById(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        val mapController = mapView.controller
        mapController.setZoom(6.5) // Zoom inicial
        val nicaragua = GeoPoint(12.8654, -85.2072) // Coordenadas de Nicaragua
        mapController.setCenter(nicaragua)

        agregarRelatos()

        return view
    }

    private fun agregarRelatos() {
        // Relatos por departamento
        val relatos = listOf(
            Triple(12.1364, -86.2514, Pair("Managua", "La Cegua, La Carreta Nagua")),
            Triple(11.9344, -85.956, Pair("Rivas", "El Güegüense")),
            Triple(13.0928, -86.0023, Pair("León", "La Gigantona, El Enano Cabezón")),
            Triple(12.523, -87.163, Pair("Chinandega", "Leyenda de Tonalá")),
            Triple(13.4833, -86.5833, Pair("Nueva Segovia", "El Padre sin Cabeza"))
        )

        relatos.forEach { (lat, lon, info) ->
            val marker = Marker(mapView)
            marker.position = GeoPoint(lat, lon)
            marker.title = "${info.first}\n${info.second}"
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            mapView.overlays.add(marker)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}