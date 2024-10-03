
# Proyecto de Ejercicios en Kotlin
Este proyecto incluye una serie de ejercicios desarrollados en Kotlin para manejar conceptos fundamentales de programación orientada a objetos. Cada ejercicio se presenta como un script independiente, utilizando clases, herencia, interfaces, y abstracciones para resolver diferentes problemas.

## PRACTICA 02

## Descripción del Proyecto

El proyecto está compuesto por los siguientes ejercicios:

1. **Cuenta Bancaria**: 
   - Clase `CuentaBancaria` que permite manejar el saldo y el límite de retiro de una cuenta bancaria. Incluye métodos para realizar depósitos, retiros, y verificar el saldo.

2. **Producto**: 
   - Clase `Producto` que permite gestionar el precio y el descuento aplicable a un producto. Incluye métodos para calcular el precio final después de aplicar un descuento.

3. **Figuras Geométricas**: 
   - Implementación de una clase abstracta `Shape` con subclases `Cuadrado`, `Circulo` y `Rectangulo`. Cada subclase implementa métodos para calcular el área y el perímetro de la figura correspondiente.

4. **Sistema de Gestión de Biblioteca**:
   - Un sistema que incluye la gestión de materiales (como libros y revistas) y usuarios en una biblioteca. Se utiliza una interfaz `IBiblioteca` para definir operaciones comunes, y la clase `Biblioteca` implementa estas operaciones permitiendo registrar, prestar y devolver materiales.

## PRÁCTICA 03

Este proyecto incluye una serie de ejercicios desarrollados en Kotlin, centrándose en el **ciclo de vida de una actividad** y el **paso de información entre actividades** en Android. Los ejercicios se desarrollan utilizando Android Studio, y cada uno aborda problemas clave relacionados con la interacción de usuario, manejo de imágenes y reproducción de audio.

## Descripción del Proyecto

### Ejercicios de la Práctica 03:

#### 1. Interacción con Imágenes
Este ejercicio permite al usuario seleccionar una imagen a través de un **spinner** y luego visualizarla en una nueva actividad. La interfaz principal contiene un spinner con una lista de nombres de imágenes y un botón para avanzar a la siguiente actividad. En la segunda actividad se muestra la imagen seleccionada y se incluye un botón para volver a la actividad anterior. Se asegura que, al volver, el estado del spinner se mantenga. También se implementa la lógica para evitar que la selección se pierda al girar el dispositivo (manejo de la rotación).

##### **Componentes Principales**:
- **Actividad Principal**: Contiene un spinner con los nombres de las imágenes y un botón para avanzar.
- **Segunda Actividad**: Muestra la imagen seleccionada y un botón para regresar a la primera actividad.
- **Persistencia de Datos**: El estado del spinner se preserva al volver a la primera actividad y también cuando se rota el dispositivo.

##### **Lógica Adicional**:
- Uso del ciclo de vida de la actividad para manejar la persistencia de datos.
- Implementación de `onSaveInstanceState` y `onRestoreInstanceState` para conservar el estado en rotaciones de pantalla.

#### 2. Reproductor de Música
Este ejercicio permite seleccionar un audio de una lista y reproducirlo en una segunda actividad. La interfaz principal contiene un **spinner** con cinco nombres de audios y un botón de "Seleccionar". Al seleccionar un audio, el usuario es dirigido a una nueva actividad donde puede ver el nombre del audio, su imagen asociada, y tiene opciones para **reproducir**, **pausar** y **detener** el audio.

##### **Componentes Principales**:
- **Primera Actividad**: Contiene un spinner con los nombres de los audios y un botón para avanzar a la actividad de reproducción.
- **Segunda Actividad**: Muestra el nombre del audio, una imagen asociada y tres botones: reproducir, pausar y detener.
- **Reproducción de Audio**: Se utiliza la clase `MediaPlayer` de Android para manejar la reproducción de los audios.

##### **Lógica Adicional**:
- Los archivos de audio se almacenan en la carpeta **res/raw** del proyecto.
- Implementación de la clase `MediaPlayer` para cargar y reproducir los audios seleccionados.
- Manejo del ciclo de vida de la actividad para pausar o detener el audio cuando la actividad cambia de estado (por ejemplo, cuando el usuario cambia de actividad o minimiza la aplicación).
 
## PRACTICA 4

Este repositorio contiene la resolución de los ejercicios de la Práctica 4 sobre el uso de Fragments en aplicaciones Android utilizando Kotlin. Los ejercicios requieren modificar las aplicaciones previas de "Interacción con Imágenes" y "Reproductor de Música" para implementarlas usando Fragments, asegurando que la interfaz y la lógica funcionen correctamente incluso cuando se rota el dispositivo.

## Ejercicios

### 1. Interacción con Imágenes versión Fragments

**Instrucciones:**
- Modificar la aplicación original para reemplazar las actividades por fragments.
- Asegurar que el estado de la imagen y otros datos persistan al rotar la pantalla.
- Implementar el `FragmentManager` para manejar la interacción entre los fragments y la actividad principal.


### 2. Reproductor de Música versión Fragments

**Instrucciones:**
- Modificar la aplicación original del reproductor de música para implementar fragments.
- Garantizar que la música continúe reproduciéndose y el estado del reproductor se conserve tras rotar la pantalla.
- Usar `FragmentTransaction` para gestionar las transiciones entre los fragments, como la lista de canciones y el reproductor.

[Enlace al Repositorio](https://github.com/mary1508/Programacion-de-Dispositivos-M-viles.git)

