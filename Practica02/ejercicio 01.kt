// Descripción: Clase para manejar una cuenta bancaria con saldo y límite de retiro.
// Autor: Marycielo Bedoya Pinto
// Fecha creación: 01/09/2024
// Fecha última modificación:

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    // Obtenemos el saldo actual
    fun getSaldo(): Double {
        return saldo
    }
    // establecemos el saldo con validación
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }
    // aqui realizamos el retiro que se pide
    fun retirar(monto: Double) {
        if (monto > limiteRetiro) {
            println("El monto excede el límite de retiro.")
        } else if (monto > saldo) {
            println("Fondos insuficientes.")
        } else {
            saldo -= monto
            println("Retiro exitoso. Saldo actual: $saldo")
        }
    }
}

