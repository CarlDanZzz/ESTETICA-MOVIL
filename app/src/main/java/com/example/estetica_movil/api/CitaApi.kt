package com.example.estetica_movil.api

import retrofit2.Response
import retrofit2.http.*
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.models.CitaRequest
import com.example.estetica_movil.models.EstadoRequest


interface CitaApi {

    @GET("citas")
    suspend fun obtenerCitas(): List<Cita>

    @GET("citas/{id}")
    suspend fun obtenerCita(@Path("id") id: Int): Cita

    @PUT("cita/{id}/estado")
    suspend fun cambiarEstado(
        @Path("id") id: Int,
        @Body body: Map<String, String>
    ): Cita

    @DELETE("citas/{id}")
    suspend fun eliminarCita(
        @Path("id") id: Int
    ): Response<Unit>

}
