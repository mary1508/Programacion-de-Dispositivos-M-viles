/* Descripcion del problema: Realizar una calculadora  básica
suma, resta, multiplicación, división. Debe imprimir
un menú con las opciones incluyendo una opción salir.
Autor: Marycielo Bedoya Pinto
Fecha de creación: 25/08/2024
Fecha de ultima modificación:
 */
fun mostrarMenu() {
    while (true) {

        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Selecciona una opción:")

        // con esto podremos tomar el dato que el usuario ingresará
        val opcion = readln().toInt()

        // esto es para ejecutar la opción seleccionada.
        when (opcion) {
            1 -> realizarSuma()
            2 -> realizarResta()
            3 -> realizarMultiplicacion()
            4 -> realizarDivision()
            5 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción inválida. Por favor, elige una opción válida.")
        }
    }
}
fun realizarSuma() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()

    // Aqui hacemos el calculo de la suma
    val resultado = num1 + num2
    println("Resultado de la suma: $resultado")
}

fun realizarResta() {
    println("Ingresa el primer número:")
    val num1 = readln().toDouble()
    println("Ingresa el segundo número:")
    val num2 = readln().toDouble()
    val resultado = num2 - num1
    println("Resultado de la resta: $resultado")
}
