# ACTIVIDADES. Practica 2. Programación Orientada a Objetos Kotlin

## CONTENIDO

### 1. PRODUCTO

Clase `Producto` que tiene un **precio** y un **descuento aplicable**.  
- Incluye métodos *set* y *get* para establecer y obtener los valores.  
- Implementa validaciones en los *setters*.  
- Método para calcular el **precio final** aplicando el descuento.  

### 2. FIGURAS (SHAPE)

Clase abstracta `Shape` con propiedades de **área** y **perímetro**, además de funciones para calcular e imprimir resultados.  
- Subclases: `Cuadrado`, `Círculo`, y `Rectángulo`.  
- Cada subclase recibe sus parámetros (lados o radio) mediante constructores.  
- Se crean instancias y se ejecutan las operaciones de área y perímetro para cada figura.  

### 3. SISTEMA DE GESTION DE BIBLIOTECA

Sistema que simula una biblioteca con diferentes materiales y usuarios.  
- **Material**: Clase abstracta con título, autor, añoPublicacion y un método abstracto `mostrarDetalles()`.  
- **Libro**: Subclase con género y número de páginas.  
- **Revista**: Subclase con ISSN, volumen, número y editorial.  
- **Usuario**: Data class con nombre, apellido y edad.  
- **IBiblioteca**: Interfaz con métodos para registrar material, registrar usuario, préstamo, devolución y mostrar materiales.  
- **Biblioteca**: Clase que implementa la interfaz y gestiona las operaciones, incluyendo préstamos y devoluciones.  

## Ejecución
Cada archivo puede ejecutarse de forma independiente en un proyecto de **Kotlin**.  
