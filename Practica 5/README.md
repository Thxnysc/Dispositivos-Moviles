# Formulario de Registro de Usuario
## Descripción

Aplicación Android desarrollada en Kotlin que permite registrar usuarios mediante un formulario interactivo con validaciones en tiempo real. El formulario incluye campos obligatorios, selección de género, estado del usuario, nivel de experiencia y aceptación de términos, con un botón de registro que se activa únicamente cuando todos los datos son válidos.

---

## Composables

### 1. `FormularioScreen`

- Pantalla principal que contiene todos los estados del formulario
- Maneja la lógica de validación en tiempo real
- Genera el resumen del usuario al registrar
- Reinicia todos los campos al limpiar

### 2. `FormularioUI`

- Interfaz visual completa del formulario con scroll vertical
- Contiene todos los campos y componentes interactivos
- Muestra mensajes de error debajo de cada campo inválido
- Presenta el resultado del registro en una `Card` destacada

### 3. `CampoTexto`

- Componente reutilizable basado en `OutlinedTextField`
- Muestra estado de error visual con borde rojo
- Muestra mensaje de error descriptivo debajo del campo cuando corresponde

---

## Validaciones

| Campo | Regla |
|---|---|
| Nombre | No puede estar vacío |
| Edad | Solo números enteros válidos |
| Correo | Debe contener `@` |
| Género | Debe seleccionarse una opción |
| Términos | El checkbox debe estar marcado |

> El botón **Registrar** permanece deshabilitado hasta que todas las validaciones sean correctas.

---

## Resultado al registrar

Al presionar el botón Registrar, se muestra un resumen con el siguiente formato:

```
Usuario Juan, 20 años, activo, nivel 7
```

---

## Botón Limpiar

Reinicia completamente el formulario:

- Campos de texto (Nombre, Edad, Correo)
- RadioButton de género
- Checkbox de términos
- Switch de estado
- Slider de nivel
- Resultado mostrado

---

## Autor

- **Anthony Stefano Cervantes Cohaila**