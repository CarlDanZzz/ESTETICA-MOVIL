package com.example.estetica_movil.repository

import com.example.estetica_movil.api.RetrofitInstance
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.api.CitaApi
import com.example.estetica_movil.models.CitaRequest
import com.example.estetica_movil.models.EstadoRequest

class CitaRepository {

    private val api = RetrofitInstance.api

    suspend fun obtenerCitas(): List<Cita> {
        return api.obtenerCitas()
    }

    suspend fun obtenerCita(id: Int): Cita {
        return api.obtenerCita(id)
    }

    suspend fun cambiarEstado(id: Int, estado: String): Cita {
        return RetrofitInstance.api.cambiarEstado(id, mapOf("estado" to estado))
    }


    suspend fun eliminarCita(id: Int){
        RetrofitInstance.api.eliminarCita(id)
    }
}
