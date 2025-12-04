package com.example.estetica_movil.viewmodel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.estetica_movil.api.RetrofitInstance
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.estetica_movil.models.Cita
import com.example.estetica_movil.models.CitaRequest
import com.example.estetica_movil.repository.CitaRepository


class CitaViewModel : ViewModel() {

    private val repository = CitaRepository()

    private val _citas = MutableStateFlow<List<Cita>>(emptyList())
    val citas: StateFlow<List<Cita>> = _citas

    init {
        obtenerCitas()
    }

    fun obtenerCitas() {
        viewModelScope.launch {
            try {
                _citas.value = repository.obtenerCitas()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun cambiarEstado(id: Int, estado: String) {
        viewModelScope.launch {
            repository.cambiarEstado(id, estado)
            obtenerCitas()
        }
    }

    fun eliminarCita(id: Int) {
        viewModelScope.launch {
            try {
                repository.eliminarCita(id)
                obtenerCitas() // refresca lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}
