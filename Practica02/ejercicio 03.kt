// Descripción: Clase abstracta para calcular área y perímetro de figuras.
// Autor: Marycielo Bedoya Pinto
// Fecha creación: 02/09/2024
// Fecha última modificación:

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}
fun main() {
    val cuadrado = Cuadrado(4.0)
    cuadrado.imprimirResultados()
}