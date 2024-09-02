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

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(5.0, 3.0)
    rectangulo.imprimirResultados()
}
