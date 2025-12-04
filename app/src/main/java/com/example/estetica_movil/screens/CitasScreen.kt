package com.example.estetica_movil.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estetica_movil.api.RetrofitInstance
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.models.CitaRequest
import com.example.estetica_movil.viewmodel.CitaViewModel
import com.example.estetica_movil.repository.CitaRepository

@Composable
fun PantallaCitas(
    viewModel: CitaViewModel = viewModel()
) {

    val citas by viewModel.citas.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        if (citas.isEmpty()) {
            item {
                Text(
                    text = "No hay citas registradas",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
        }

        items(citas) { cita ->

            // Color según estado
            val colorEstado = when (cita.estado) {
                "realizada" -> Color(0xFFB2FFB2)   // verde clarito
                "cancelada" -> Color(0xFFFFB2B2)   // rojo clarito
                else -> Color(0xFFFFF3B0)          // amarillito
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(colorEstado)
                        .padding(16.dp)
                ) {

                    Text(
                        text = "Cita #${cita.id}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Cliente ID: ${cita.cliente_id}")
                    Text("Personal ID: ${cita.personal_id}")
                    Text("Fecha: ${cita.fecha}")
                    Text("Hora: ${cita.hora}")

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Estado: ${cita.estado}",
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // BOTONES
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        var expanded by remember { mutableStateOf(false) }

                        Box {
                            Button(onClick = { expanded = true }) {
                                Text("Cambiar estado")
                            }

                            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

                                DropdownMenuItem(
                                    text = { Text("Pendiente") },
                                    onClick = {
                                        viewModel.cambiarEstado(cita.id, "pendiente")
                                        expanded = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = { Text("Realizada") },
                                    onClick = {
                                        viewModel.cambiarEstado(cita.id, "realizada")
                                        expanded = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = { Text("Cancelada") },
                                    onClick = {
                                        viewModel.cambiarEstado(cita.id, "cancelada")
                                        expanded = false
                                    }
                                )
                            }
                        }


                        Button(
                            onClick = { viewModel.eliminarCita(cita.id) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE53935)
                            )
                        ) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }
    }
}

