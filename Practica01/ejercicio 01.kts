fun obtenerNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun main() {
    println("Ingrese su puntuación: ")
    val puntuacion = readLine()?.toInt()

    println("Ingrese su salario mensual: ")
    val salario = readLine()?.toInt()

    val nivel = obtenerNivelRendimiento(puntuacion!!)
    println("Nivel de rendimiento: $nivel")
}
