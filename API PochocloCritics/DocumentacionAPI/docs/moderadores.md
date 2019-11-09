# Moderadores del Sistema

## Listar todos los moderadores

Obtiene una lista con todos los moderadores registrados en el sistema.

### URL solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idModerador":1234, "privilegio": "moderador", "correo": "correo@correo", "nombre": "mark", "apellido": "jones", "fecha_nacimiento": "22/01/95", "alias": "mark"},
  { "idModerador":3348, "privilegio": "moderador", "correo": "correo@correo", "nombre": "julia", "apellido": "carpenter", "fecha_nacimiento": "27/03/92","alias": "julia"},
  { "idModerador":2378, "privilegio": "moderador", "correo": "correo@correo", "nombre": "Pablo", "apellido": "morales", "fecha_nacimiento": "01/01/97","alias": "bob"},
]
```

De lo contrario se indicará los siguientes posibles errores:

>**400 Bad Request** => mensaje de error del lado del cliente

>**500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

>No retorna la contraseña del Moderador

---

## Obtener un moderador

Obtiene un moderador gistrador en el sistema segun su identificador.

### URL solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
  { "idModerador":1234, "privilegio": "moderador", "correo": "correo@correo", "nombre": "mark", "apellido": "jones", "fecha_nacimiento": "22/01/95", "alias": "mark"}
```

De lo contrario se indicará los siguientes posibles errores:

>**400 Bad Request** => mensaje de error del lado del cliente

>**500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

>No devuelve la contraseña del Moderador

---

## Listar una reseña solicitada por un moderador (idModerador) en el Sistema 

Obtiene una reseña según el moderador (idModerador) registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores/1234/reseñas/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {
   "idReseña": 1234,
   "descripcion": "Buenisima",
   "idPelicula": 2344,
   "pelicula": "El señor de los Anillos"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que la reseña se solicitó segun el moderador

---

## Listar todas las reseñas solicitadas por un moderador (idModerador) en el Sistema

Obtiene todas las reseñas según el Moderador (idModerador) registradas en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores/1234/reseñas>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idReseña": 5412, "descripcion": "Buenisima la peli", "idPelicula": 5009, "pelicula": "El señor de los Anillos"},
  { "idReseña": 3332, "descripcion": "Pesima", "idPelicula": 3412, "pelicula": "Mad Max"},
  ...
  { "idReseña": 4465, "descripcion": "Me encantó", "idPelicula": 5622, "pelicula": "Harry Potter"}  
]
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que las reseñas se solicitadas son de un moderador en específico

---

## Listar Preferencias del Moderador

Obtiene una preferencia solicitada por un moderador (idModerador) registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/moderador/1234/preferencias/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {
   "idPreferencia": 1234,
   "genero": [],
   "actor": [],
   "director": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que se lista una preferencia solicitada por un moderador específico. 

---

## Crear un moderador

Alta de un moderador en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
  "privilegio": "moderador",
  "correo": "correo@correo",
  "nombre": "mark",
  "apellido": "jones",
  "fecha_nacimiento": "22/01/95",
  "alias": "mark",
  "contraseña": "adb234ht"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el moderador creado:

```json
{
  "idModerador":1234,
  "privilegio": "moderador",
  "correo": "correo@correo",
  "nombre": "mark",
  "apellido": "jones",
  "fecha_nacimiento": "22/01/95",
  "alias": "mark"
}
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente.

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

> No devuelve la contraseña del Moderador

> El identificador "idModerador" es generado de forma automática

---

## Actualizar un moderador

Actualización de los atributos de un moderador en en sistema.

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v2.0/moderador/1234>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
  "correo": "correo@correo",
  "nombre": "mark",
  "apellido": "jones",
  "fecha_nacimiento": "22/01/95",
  "alias": "mark",
  "contraseña": "adb234ht"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el moderador actualizado:

```json
{
  "idModerador":1234,
  "privilegio": "moderador",
  "correo": "correo@correo",
  "nombre": "mark",
  "apellido": "jones",
  "fecha_nacimiento": "22/01/95",
  "alias": "mark",
}
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> El identificador del moderador y su privilegio no puede ser cambiado

> no devuelve la contraseña del Moderador

---

## Eliminar un moderador

Elimina un moderador del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v2.0/moderadores/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor
