# Usuarios del Sistema

## Listar todos los usuarios

Obtiene una lista con todos los usuarios registrados en el sistema.

### URL solicitud

> Solicitud => GET "<https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios">

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

>Solicitud => GET  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios/1234>

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

## Crear un usuario

Alta de un usuario en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios>

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

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios/3412>

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

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor
