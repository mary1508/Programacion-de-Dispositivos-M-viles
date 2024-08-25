/*
Descripción: Crear un programa que, basándose en la puntuación de evaluación de un empleado (de 0 a 10)
y su salario mensual, determine su nivel de rendimiento (Inaceptable, Aceptable o Meritorio)
y se pueda calcular la cantidad de dinero que recibirá. La cantidad se obtiene multiplicando el
salario por el porcentaje de la puntuación sobre 10.

Autor: Marycielo Bedoya Pinto
Fecha de creación: 24/08/24
Fecha de ultima modificación: 24/08/24 23:38*/

fun obtenerNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDinero(puntuacion: Int, salario: Int): Double {
    return salario * (puntuacion / 10.0)
}

fun main() {
    println("Ingrese su puntuación: ")
    val puntuacion = readLine()?.toIntOrNull()
    if (puntuacion == null || puntuacion < 0 || puntuacion > 10) {
        println("Puntuación inválida")
        return
    }

    println("Ingrese su salario mensual: ")
    val salario = readLine()?.toIntOrNull()
    if (salario == null || salario <= 0) {
        println("Salario inválido")
        return
    }

    val nivel = obtenerNivelRendimiento(puntuacion)
    val dinero = calcularDinero(puntuacion, salario)

    println("Nivel de rendimiento: $nivel")
    println("Cantidad de dinero recibido: $${dinero.toInt()}")
}

