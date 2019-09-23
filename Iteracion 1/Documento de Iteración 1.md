# PochocloCritics - Sistema de crítica de Películas.

### Grupo: La comunidad del Anillo.

1. Rivas Rodriguez Rosa.
2. Nahirñak Fernando.
3. Zakowicz Osvaldo.

## Visión
Desarrollaremos un  sistema de recomendación de películas que  permitirá a un usuario visualizar el top de las películas
recomendadas dependiendo del puntaje que cada usuario le otorgue, le permitirá puntuar películas desde su perfil, escribir 
una breve reseña o acceder desde la la aplicación de reseñas a sitios donde poder ver la pelicula online.

## Características:
1. Publicación de una película para su reseña 
2. Clasificación de las películas según un género
3. Perfil y preferencias del usuario
4. Explorar catálogo
5  Reseña y puntuación de la pelicula (usuario).
6. Recomendar películas a otros usuarios

## Dominio
La aplicación está dedicada en un contexto de entretenimiento a personas que busquen recomendaciones de películas, puntuar y 
escribir sus propias reseñas, además de recomendar películas a otros usuarios, no solo de películas reconocidas internacionalmente si no también en el contexto nacional, o regional.

## Bocetos de Interfaz
### Pantalla Principal
La pantalla principal es la vista inicial del usuario/administrador, desde aquí parten las acciones siguientes del sistema.

![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/pantalla_principal.png "Pantalla Principal")

### Administrar Película
La pantalla de publicación de película le permite al administrador subir una película al sistema.
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/administrar_pelicula.png "Administrar Pelicula")

### Realizar Reseña
La pantalla de realizar reseña le permite al usuario reseñar una película, clasificarla por estrellas o ver las últimas reseñas.
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/realizar_resena.png "Reseñar Pelicula")

### Recomendar Película
La pantalla de recomendar película le permite al usuario enviarle una película y un mensaje opcional a otro usuario.
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/recomendar_pelicula.png "Recomendar Pelicula")

### Añadir Elenco
La pantalla de añadir elenco le permite al administrador añadir un Actor-a/Director-a al sitio.
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/anadir_elenco.png "Añadir Elenco")

### Registrar Preferencias
La pantalla de registrar preferencias le permite al usuario indicar sus preferencias de cine.
![alt text](https://github.com/RosyRivas/Proyecto-POO2-2019/blob/master/Iteracion%201/registrar_preferencias.png "Registrar Preferencias")

## Casos de Uso.
### Actores del Sistema.
1. Usuario: el rol de usuario abarca las funciones básicas del sistema de reseñas de películas como ser visualizar las películas en el orden de preferencias, reseñar, puntuar y compartir películas.
2. Administrador: el rol de administrador se encarga de la parametrización del sistema (ABM de películas, actores, directores y género).

---

### Registrar preferencias
##### Actores: Usuario
##### Objetivo: registrar las preferencias de cine de un usuario
##### Flujo Principal:
1. El caso de uso comienza cuando el actor desea registrar sus preferencias de cine.
2. El sistema requiere los datos de las preferencias del actor.
3. El actor proporciona los datos de sus preferencias.
4. El actor confirma la operación.
5. El sistema emite un mensaje de operación exitosa.

---

### Administrar película
#### Actores: Administrador
#### Objetivo: realizar el alta, baja o modificación de una película
##### Flujo Principal:
1. El caso de uso comienza cuando el actor quiere administrar una película.
2. El sistema requiere los datos de la película.
3. El actor proporciona los datos solicitados.
4. El actor confirma la operación.
5. El sistema emite un mensaje de operación exitosa.

---

### Realizar Reseña
#### Actores: Usuario
#### Objetivo: realizar  reseña de una película determinada  
##### Flujo Principal:
1. El caso de uso comienza cuando el actor quiere realizar una reseña a una película.
2. El sistema requiere que ingrese una calificación y una reseña.
3. El actor ingresa una calificación con su respectiva reseña.
4. El actor confirma la operación.
5. El sistema emite   un mensaje de operación exitosa.
##### Curso alternativo
paso 2: el actor  no ingresa reseña y  sigue el flujo típico de eventos.

---

### Añadir elenco
#### Actores: Administrador
#### Objetivo: añadir un actor o director
##### Flujo Principal:
1. El caso de uso comienza cuando el administrador quiere añadir actores o directores a una película.
2. El sistema requiere que ingrese datos del actor o director y la película en la que participa.
3. El administrador confirma la operación realizada.
4. El sistema emite   un mensaje de operación exitosa.
##### Curso alternativo
paso 2: de no existir una película, y sigue el flujo típico de evento.

---

### Explorar Catálogo
#### Actores: Usuario, Administrador
#### Objetivo: Explorar el catálogo para observar estrenos, géneros disponibles, las películas favoritas y reseñas.
##### Flujo Principal:
1. El caso de uso comienza cuando el actor consulta un catálogo.
2. El sistema muestra el catalogo seleccionado con sus datos.
3. El actor vuelve a explorar. 

4. del 1 al 3 puede repetirse.
5. El actor selecciona una pelicula.

---

### Recomendar Película
#### Actores: Usuario
#### Objetivo: Realizar la recomendación de una película
##### Flujo Principal:
1. El caso de uso comienza cuando el actor quiere realizar una recomendación de una película.
2. El sistema requiere  que ingrese el destinatario y el mensaje.
3. El actor proporciona los datos solicitados.
4. El actor confirma la operación.
5. El sistema emite un mensaje de operación exitosa.

---

##### Glosario de Términos

###### Administrar Película: 
Se refiere a la acción de realizar un alta, baja y modificación de una película.
###### Reseñar Película: 
Se refiere a la acción de realizar una reseña de una película, lo que incluye la calificación de la película y un comentario opcional de la misma.
###### Explorar el Catálogo: 
Se refiere a la acción de explorar colecciones de películas desde la pantalla principal.
###### Catálogo:
se refiere a una colección de películas ordenada por género, recomendación o preferencias.
###### Recomendar Película:
Se refiere a la acción de enviar una película como recomendación a otro usuario, junto a un comentario opcional.
###### Añadir Elenco:
Se refiere a la acción de añadir un elenco nuevo al sistema, ya sea un actor/a o director/a
###### Elenco:
El elenco es un conjunto de actores y directores que participan en una película.
###### Registrar Preferencias:
Se refiere a las preferencias del usuario en el campo del cine, lo que incluye el género de sus películas favoritas y sus actores y directores favoritos.

---

## Arquitectura:

* Postgresql
* Netbeans 11.1  con Java
* Javalin con Json 
* Html+Css
* Javascript
* Bootstrap 4  





