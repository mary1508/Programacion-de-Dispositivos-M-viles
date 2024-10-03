package com.example.ejercicio01depractica5

/*
Descripción: Modelo de datos para un audio.
Autor: Marycielo Bedoya Pinto
Fecha creación: 02/10/2024
Fecha última modificación: 03/10/2024
*/

data class Audio(
    val nombre: String,
    val imagenResId: Int,
    val duracion: String,
    val audioResId: Int
)
