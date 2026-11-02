# Fidness - Avance 2

Aplicación de escritorio en Java para consultar ejercicios del gimnasio Fidness.

## Cómo ejecutar

1. Abrir el proyecto en NetBeans
2. Ejecutar con Run (clase principal: `fidness.Main`).

## Usuarios precargados

| Usuario | Contraseña |
|---------|------------|
| Romario | 1234       |
| Ana     | abcd       |
| Carlos  | 1111       |

El usuario y la contraseña distinguen entre mayúsculas y minúsculas.

## Cómo usar la aplicación

1. Iniciar sesión: ingresar usuario y contraseña y presionar "Iniciar Sesion". Si hay campos vacíos o los datos son incorrectos, se muestra un mensaje de error.
2. Filtrar el catálogo: en el combo "Tipo" elegir Todos, Pierna, Espalda o Brazo. La lista se actualiza al seleccionar.
3. Ver un ejercicio: hacer clic sobre un ejercicio para abrir su detalle (tipo, músculos, video e instrucciones). Con "Regresar al catálogo" se vuelve a la lista.
4. Cerrar sesión: presionar "Salir" en la barra inferior para volver al inicio de sesión.

## Historias de usuario implementadas

Historia 1 Inicio de Sesion, Historia 3 Catalogo de Ejercicios, Historia 5 Detalle de los ejercicios e Historia 9 Cerrar Sesion.

Los botones "Mis rutinas", "Crear rutina" y "Registrar Ejercicio" aparecen en la barra inferior según el prototipo, pero se implementarán en un próximo avance.
