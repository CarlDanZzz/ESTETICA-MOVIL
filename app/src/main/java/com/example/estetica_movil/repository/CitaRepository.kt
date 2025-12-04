package com.example.estetica_movil.repository

import com.example.estetica_movil.api.RetrofitInstance
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.api.CitaApi
import com.example.estetica_movil.models.CitaRequest

class CitaRepository {

    private val api = RetrofitInstance.api

    suspend fun obtenerCitas(): List<Cita> {
        return api.obtenerCitas()
    }

    suspend fun obtenerCita(id: Int): Cita {
        return api.obtenerCita(id)
    }

}
