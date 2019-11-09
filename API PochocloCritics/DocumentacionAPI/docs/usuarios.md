# Usuarios del Sistema

## Listar todos los usuarios

Obtiene una lista con todos los usuarios registrados en el sistema.

### URL solicitud

> Solicitud => GET "<https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios">

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
    { "idUsuario": 1234, "correo": "uncorreo@algo.com", "nombre": "carlos", "apellido": "sanz", "fecha_nacimiento": "23/05/92", "alias": "carl" },
    { "idUsuario": 2334, "correo": "uncorreo@algo.com", "nombre": "marta", "apellido": "dias", "fecha_nacimiento": "03/09/94", "alias": "martad" },
    ...
]
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario

---

## Obtener un usuario

Obtiene un usuario según su identificador (idUsuario)

### URL Solicitud

>Solicitud => GET  <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
  {
    "idUsuario": 1234,
    "correo": "uncorreo@algo.com",
    "nombre": "carlos",
    "apellido": "sanz",
    "fecha_nacimiento": "23/05/92",
    "alias": "carl" 
  }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario

---

## Listar una reseña solicitada por un usuario (idUsuario) en el Sistema

Obtiene una reseña según el usuario(idUsuario) registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/usuario/1234/reseñas/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {  
   "idReseña": 1234,
   "descripcion": "Buenisima",
   "idPelicula": 1234,
   "titulo": "El señor de los Anillos"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que la reseña se solicitó según el idUsuario especificado y de un idReseña especificado

---

## Listar todas las reseñas solicitadas por un usuario (idUsuario) en el Sistema

Obtiene todas las reseñas del usuario (idUsuario) registradas en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios/1234/reseñas>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idReseña": 1234, "descripcion": "Buenisima la peli", "idPelicula": 1234, "pelicula": "El señor de los Anillos"},
  { "idReseña": 3412, "descripcion": "Pesima", "idPelicula": 6089, "pelicula": "Mad Max"},
  ...
  { "idReseña": 5477, "descripcion": "Me encantó", "idPelicula": 6008, "pelicula": "Harry Potter"}  
]
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que las reseñas se solicitaron segun un usuario en específico

---

## Listar Preferencias del Usuario

Obtiene una preferencia solicitada por un usuario (idUsuario) registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios/1234/preferencias/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {  
   "idPreferecia": 1234,
   "genero": [],
   "actor": [],
   "director": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que se lista una preferencia solicitada por un usuario específico.

---

## Crear un usuario

Alta de un usuario en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
    "correo": "uncorreo@algo.com",
    "nombre": "carlos",
    "apellido": "sanz",
    "fecha_nacimiento": "23/05/92",
    "alias": "carl",
    "contraseña": "lopr56t"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario creado:

```json
{
    "idUsuario": "3412",
    "correo": "uncorreo@algo.com",
    "nombre": "carlos",
    "apellido": "sanz",
    "fecha_nacimiento": "23/05/92",
    "alias": "carl",
}
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente.

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idUsuario reciente creado.

> No devuelve la contraseña del usuario.

---

## Actualizar un usuario

Actualización de los atributos de un usuario en en sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios/3412>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
    "correo": "uncorreo@algo.com",
    "nombre": "carlos",
    "apellido": "sanz",
    "fecha_nacimiento": "23/05/92",
    "alias": "carl",
    "contraseña": "lopr56t"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario actualizado:

```json
{
    "idUsuario": "3412",
    "correo": "uncorreo@algo.com",
    "nombre": "carlos",
    "apellido": "sanz",
    "fecha_nacimiento": "23/05/92",
    "alias": "carl",
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario

---

## Eliminar un usuario

Elimina un usuario del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v2.0/usuarios/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor
