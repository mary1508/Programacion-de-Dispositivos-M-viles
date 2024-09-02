// Descripción: Clase para manejar una cuenta bancaria con saldo y límite de retiro.
// Autor: Marycielo Bedoya Pinto
// Fecha creación: 01/09/2024
// Fecha última modificación:

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    // Obtenemos el saldo actual
    fun getSaldo(): Double {
        return saldo
    }
}
