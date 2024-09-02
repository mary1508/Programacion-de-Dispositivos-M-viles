// Descripción: Sistema de Gestión de Biblioteca con clases para materiales y usuarios.
// Autor: Marycielo Bedoya Pinto
// Fecha creación: 02/09/2024
// Fecha última modificación:

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            usuarios[usuario]?.add(material)
            materialesDisponibles.remove(material)
            println("Material prestado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("Material no disponible.")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.remove(material) == true) {
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El usuario no tiene este material en préstamo.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}
fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("Mi familia y otras miserias", "Orlando Mazeyra", 2013, "cuento", 155)
    val revista1 = Revista("Vogue", "Varios", 2023, "0031-5850", 101, 2, "NGM")

    val usuario1 = Usuario("Juan", "Alcachofa", 25)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
}