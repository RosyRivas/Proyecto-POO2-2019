# Usuarios del Sistema

## Listar todos los usuarios

Obtiene una lista con todos los usuarios registrados en el sistema.

### URL solicitud

> Solicitud => GET "<https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios">

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
{
    [
        { "idUsuario": "1234", "correo": "uncorreo@algo.com", "alias": "carl" },
        { "idUsuario": "5412", "correo": "uncorreo@algo.com", "alias": "jhon" },
        { "idUsuario": "4312", "correo": "uncorreo@algo.com", "alias": "Rick" },
        ...
        { "idUsuario": "4312", "correo": "uncorreo@algo.com", "alias": "Rick" }
    ]
}
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario, Es necesario que devuelva los atributos heredados de la clase Persona

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
    "idUsuario": "1234",
    "correo": "uncorreo@algo.com",
    "alias": "carl"
  }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario, Es necesario que devuelva los atributos heredados de la clase Persona

---

## Crear un usuario

Alta de un usuario en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
    "contraseña": "kghhdt3125",
    "correo": "uncorreo@algo.com",
    "alias": "mike"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario creado:

```json
{
    "idUsuario": "3412",
    "correo": "uncorreo@algo.com",
    "alias": "mike"
}
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idUsuario reciente creado.
> No devuelve la contraseña del usuario, Es necesario que devuelva los atributos heredados de la clase Persona.

---

## Actualizar un usuario

Actualización de los atributos de un usuario en en sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios/3412>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
    "contraseña": "kghhdt3125",
    "correo": "uncorreo@algo.com",
    "alias": "maria"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario actualizado:

```json
{
    "idUsuario": "3412",
    "correo": "uncorreo@algo.com",
    "alias": "maria"
}
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> No devuelve la contraseña del usuario, Es necesario que devuelva los atributos heredados de la clase Persona

---

## Eliminar un usuario

Elimina un usuario del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/usuarios/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor
