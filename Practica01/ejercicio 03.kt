
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
