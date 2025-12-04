package com.example.estetica_movil.models

data class CitaRequest(
    val fecha: String,
    val hora: String,
    val cliente_id: Int,
    val personal_id: Int,
    val estado: String = "pendiente"
)
