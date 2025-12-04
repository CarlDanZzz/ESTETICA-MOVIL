package com.example.estetica_movil.api

import retrofit2.Response
import retrofit2.http.*
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.models.CitaRequest


interface CitaApi {

    @GET("citas")
    suspend fun obtenerCitas(): List<Cita>

    @GET("citas/{id}")
    suspend fun obtenerCita(@Path("id") id: Int): Cita

}
