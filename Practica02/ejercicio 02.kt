// Descripción: Clase para manejar un producto con precio y descuento aplicable.
// Autor: Marycielo Bedoya
// Fecha creación: 01/09/2024
// Fecha última modificación: 01/09/2024

class Producto(private var precio: Double, private var descuento: Double) {

    // Getter para obtener el precio y el descuento
    fun getPrecio(): Double {
        return precio
    }
    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo.")
        }
    }
    fun getDescuento(): Double {
        return descuento
    }

    // establecemos el descuento con validación
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El descuento debe estar entre 0 y 100.")
        }
    }

}
