// Descripción: Clase para manejar un producto con precio y descuento aplicable.
// Autor: Marycielo Bedoya
// Fecha creación: 01/09/2024
// Fecha última modificación: 01/09/2024

class Producto(private var precio: Double, private var descuento: Double) {

    // Getter para obtener el precio
    fun getPrecio(): Double {
        return precio
    }
}
