# PochocloCritics

## Sistema de Crítica de Películas

### Grupo: La Comunidad del Anillo

1. Rivas Rodriguez Rosa.
2. Nahirñak Fernando.
3. Zakowicz Osvaldo.

### Logo de PochocloCritics

![alt image](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Logo/popcorn%202.png "Nuestro Logo :)")

## Visión

Desarrollaremos un Sistema de Reseña de Películas que le permitirá a un usuario visualizar el top de las películas recomendadas
dependiendo del puntaje  de cada película o según sus preferencias, podrá puntuar películas desde su perfil y escribir una breve reseña de la misma, así como repostear la película en su perfil **"Apartado de mis reseñas"**. Por otro lado le permitirá a un usuario moderador las funcionalidades de un usuario estándar y los privilegios de publicación de una película y de añadir su elenco, lo que incluye actores y directores de cine.

## Características

1. Perfil y preferencias de Usuario.
2. Publicación de una película para su reseña.
3. Explorar Catálogo.

### Características Extendidas

1. Clasificación de las películas según un género.
2. Visualización del Catálogo según sus preferencias.
3. Reseña y puntuación de la pelicula.
4. Repostear película en el perfil.
5. Recomendar películas a otros usuarios.

## Dominio

La aplicación está dedicada en un contexto de entretenimiento a personas que busquen recomendaciones de películas, puntuar y 
escribir sus propias reseñas, además de repostear películas a otros usuarios, no solo de películas reconocidas internacionalmente si no también en el contexto nacional, o regional.

### Modelo de Dominio



## Bocetos de Interfaz

### Pantalla de Inicio de Sesión

La pantalla de inicio de sesión es la primera pantalla del sistema, permite ingresar al mismo o registrarse.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/iniciar_sesion.png "Interfaz de inicio de sesión")

## Casos de Uso

## Actores del Sistema

1. **Usuario**: el rol de usuario abarca las funciones básicas del sistema de reseñas de películas como ser visualizar las películas en el orden de preferencias, reseñar, puntuar y compartir películas.
2. **Moderador**: el rol de Moderador se encarga de la parametrización del sistema (ABM de películas, actores, directores).

---

### Registrar preferencias

#### Actor: Usuario

#### Objetivo: registrar las preferencias de cine de el usuario

##### Flujo Principal

1. El caso de uso comienza cuando el actor desea registrar sus preferencias de cine.
2. El sistema requiere los datos de las preferencias del actor.
3. El actor proporciona los datos de sus preferencias y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

### Pantalla Registrar Preferencias

La pantalla de registrar preferencias le permite al usuario indicar sus preferencias de cine.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/registrar_preferencias.png "Interfaz de preferencias")

---

### Administrar película

#### Actor: Moderador

#### Objetivo: realizar el alta, baja o modificación de una película

##### Flujo Principal de alta

1. El caso de uso comienza cuando el actor quiere realizar el alta de una película.
2. El sistema requiere los datos de la película.
3. El actor proporciona los datos solicitados y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

###### Flujo alternativo de modificación

1. El caso de uso comienza cuando el actor quiere realizar la modificación de una película.
2. El sistema requiere los datos de la película.
3. El actor proporciona los datos solicitados y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

###### Flujo alternativo de baja

1. El caso de uso comienza cuando el actor quiere realizar la baja de una película.
2. El sistema requiere clave de confirmación para la operación.
3. El actor proporciona la clave y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

### Pantalla Administrar Película

La pantalla de publicación de película le permite al administrador subir una película al sistema, modificarla o eliminarla.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/administrar_pelicula.png "Interfaz de administración de una película")

---

### Realizar Reseña

#### Actor: Usuario

#### Objetivo: realizar la reseña de una película

##### Flujo Principal

1. El caso de uso comienza cuando el actor quiere realizar una reseña a una película.
2. El sistema requiere que ingrese una calificación y/o una reseña.
3. El actor ingresa una calificación con su respectiva reseña y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

##### Curso alternativo

1. paso 2: el actor no ingresa reseña y sigue el flujo típico de eventos.

### Pantalla Realizar Reseña

La pantalla de realizar reseña le permite al usuario reseñar una película, clasificarla por estrellas o ver las últimas reseñas.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/realizar_resena.png "Interfaz para realizar reseña")

---

### Añadir elenco

#### Actor: Moderador

#### Objetivo: añadir un elenco (actor y/o director)

##### Flujo Principal

1. El caso de uso comienza cuando el actor quiere añadir un elenco.
2. El sistema requiere que ingrese datos del elenco.
3. El actor proporciona los datos solicitados y confirma la operación realizada.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

### Pantalla Añadir Elenco

La pantalla de añadir elenco le permite al administrador añadir un Actor-a/Director-a al sitio.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/anadir_elenco.png "Interfaz para añadir elenco")

---

### Explorar Catálogo

#### Actor: Usuario, Moderador

#### Objetivo: explorar el catálogo para observar estrenos, géneros disponibles, las películas favoritas y reseñas

##### Flujo Principal

1. El caso de uso comienza cuando el actor consulta un catálogo.
2. El sistema visualiza el catalogo seleccionado.
3. El actor vuelve a explorar.
4. del 1 al 3 puede repetirse.
5. El actor selecciona una pelicula.

### Pantalla Principal (Perfil de Usuario)

La pantalla principal o perfil de usuario es la vista inicial del usuario/administrador, desde aquí parten las acciones siguientes del sistema.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/pantalla_principal.png "Interfaz de Pantalla principal o Perfil")

---

### Recomendar Película

#### Actor: Usuario

#### Objetivo: realizar la recomendación de una película

##### Flujo Principal

1. El caso de uso comienza cuando el actor quiere realizar la recomendación de una película.
2. El sistema requiere que ingrese el destinatario.
3. El actor proporciona los datos solicitados y confirma la operación.
4. El sistema registra la operación y emite un mensaje de acción exitosa.

### Pantalla Recomendar Película

La pantalla de recomendar película le permite al usuario enviarle una película y un mensaje opcional a otro usuario.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/Interfaces%20v2/recomendar_pelicula.png "Interfaz para recomendar una película")

---

## Documentación Interfaz (API)

---

## Diagrama de Clases
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%202/diagramaDeClase.png)
---

## Javadoc

---

## Arquitectura

* Postgresql
* Netbeans 11.1  con Java
* Entorno de desarrollo de APIs Insomnia.
* Javalin 
* Html+Css
* Javascript con el framework react.js
* Framework Bootstrap 4
* Javadocs y MkDocs para las documentaciones.

---

##### Glosario de Términos

###### Administrar Película

Se refiere a la acción de realizar un alta, baja y modificación de una película.

###### Reseñar Película

Se refiere a la acción de realizar una reseña de una película, lo que incluye la calificación de la película y un comentario opcional de la misma.

###### Explorar el Catálogo

Se refiere a la acción de explorar colecciones de películas desde la pantalla principal.

###### Catálogo

se refiere a una colección de películas ordenada por género, recomendación o preferencias.

###### Recomendar Película

Se refiere a la acción de enviar una película como recomendación a otro usuario, junto a un comentario opcional.

###### Añadir Elenco

Se refiere a la acción de añadir un elenco nuevo al sistema, ya sea un actor/a o director/a

###### Elenco

El elenco es un conjunto de actores y directores que participan en una película.

###### Registrar Preferencias

Se refiere a las preferencias del usuario en el campo del cine, lo que incluye el género de sus películas favoritas y sus actores y directores favoritos.
