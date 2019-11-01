# Peliculas del Sistema

## Listar todas las películas

Obtiene una lista con todas las películas registradas en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/peliculas>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idPelicula": 1234, "titulo": "Mad Max", "duración": "2:48 hrs", "sinopsis": "descripcionbreve", "genero[]"},
  { "idPelicula": 1734, "titulo": "Harry Potter", "duración": "2:48 hrs", "sinopsis": "descripcionbreve", "genero[]"},
  ...
  { "idPelicula": 1294, "titulo": "El señor de los Anillos", "duración": "2:48 hrs", "sinopsis": "descripcionbreve", "genero[]"}  
]
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> La duración se indica en formato string

> El genero es un array

---

## Obtener una Película

Obtiene una película  registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/peliculas/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {
   "idPelicula": 1234,
   "titulo": "Mad Max",
   "duración": "2:48 hrs",
   "sinopsis": "descripcionbreve",
   "genero": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> La duración se indica en formato string

> El genero es un array

---

## Crear una película

Alta de una pelicula en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/peliculas>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "titulo": "Mad Max",
   "duración": "2:48 hrs",
   "sinopsis": "descripcionbreve",
   "genero": [ ]
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la película creada:

```json
{  
   "idPelicula": 1234,
   "titulo": "Mad Max",
   "duración": "2:48 hrs",
   "sinopsis": "descripcionbreve",
   "genero": [ ]
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente.

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idPelicula reciente creada.

---

## Actualizar una película

Actualización de una pelicula en el sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/peliculas/1234>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "titulo": "Mad Max",
   "duración": "3:08 hrs",
   "sinopsis": "descripcionbreve",
   "genero": [ ]
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la pelicula actualizada:

```json
  {  
   "idPelicula": 1234,
   "titulo": "Mad Max",
   "duración": "3:08 hrs",
   "sinopsis": "descripcionbreve",
   "genero": [ ]
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente.

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idPelicula reciente actualizada.

---

## Eliminar una película

Elimina una pelicula del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/peliculas/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor
