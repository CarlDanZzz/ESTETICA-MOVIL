package com.example.estetica_movil.models

data class Cita(
    val id: Int,
    val fecha: String,
    val hora: String,
    val estado: String,
    val cliente_id: Int,
    val personal_id: Int,
)
