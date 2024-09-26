package com.example.myapplication4


class Usuario(
    var nombre: String,
    var edad: Int,
    var trabajo: String? = null,
    var referencia: Usuario? = null
) {
    fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        println("Trabajo: ${trabajo ?: "No especificado"}")
        println("Referencia: ${referencia?.nombre ?: "No especificada"}")
        println()
    }
}

class Listado {
    private val listaUsuarios = mutableListOf<Usuario>()

    // Función AGREGAR
    fun agregarUsuario(usuario: Usuario) {
        listaUsuarios.add(usuario)
        println("Usuario ${usuario.nombre} agregado a la lista.")
    }

    // Función ELIMINAR
    fun eliminarUsuario(nombre: String) {
        val usuarioAEliminar = listaUsuarios.find { it.nombre == nombre }
        if (usuarioAEliminar != null) {
            listaUsuarios.remove(usuarioAEliminar)
            println("Usuario $nombre eliminado de la lista.")
        } else {
            println("Usuario $nombre no encontrado.")
        }
    }

    // Función MOSTRAR
    fun mostrarLista() {
        if (listaUsuarios.isEmpty()) {
            println("La lista de usuarios está vacía.")
        } else {
            println("Lista de usuarios:")
            listaUsuarios.forEach { it.mostrarDatos() }
        }
    }

    // Función FILTRAR
    fun filtrarUsuarios(edadMinima: Int): List<Usuario> {
        return listaUsuarios.filter { it.edad >= edadMinima }
    }
}
// Se ejecuta el codigo desde aqui.

fun main() {
    var listado = Listado()

    // Crear algunos usuarios
    var usuario1 = Usuario(nombre = "Nimona", edad = 26, trabajo = "cartera")
    var usuario2 = Usuario(nombre = "Arale", edad = 37, trabajo = null, referencia = usuario1)
    var usuario3 = Usuario(nombre = "Akane", edad = 18, trabajo = "científica")
    var usuario4 = Usuario(nombre = "Goku", edad = 42, trabajo = "luchador", referencia =null)
    var usuario5 = Usuario(nombre = "Kang", edad = 19, trabajo = "Actor")

    // Agrego los usuarios a la lista
    listado.agregarUsuario(usuario1)
    listado.agregarUsuario(usuario2)
    listado.agregarUsuario(usuario3)
    listado.agregarUsuario(usuario4)
    listado.agregarUsuario(usuario5)

    // muestro lista completa
    listado.mostrarLista()

    // Eliminar un usuario y mostrar la lista actualizada
    listado.eliminarUsuario("Nimona")
    listado.mostrarLista()

    // Filtrar usuarios por edad >= 25
    var usuariosFiltrados = listado.filtrarUsuarios(25)
    println("Usuarios mayores o iguales a 25 años:")
    usuariosFiltrados.forEach { println("Nombre: ${it.nombre}, Edad: ${it.edad}") }
}
