# Actores del Sistema

## Listar todos los actores

Obtiene una lista con todos los actores registrados en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/actores>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idActor": "1234", "biografia": "subiografia"},
  { "idActor": "1574", "biografia": "subiografia"},
  ...
  { "idActor": "1114", "biografia": "subiografia"}
]
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Es necesario que devuelva los atributos heredados de la clase Persona

---

## Obtener un actor

Obtiene un actor según su identificador (idActor)

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/actores/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
  {
    "idActor": "1234", 
    "biografia": "subiografia"
  }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Es necesario que devuelva los atributos heredados de la clase Persona

---

## Crear un actor

Alta de un actor en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/actores>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
  "biograia": "subiografia"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario creado:

```json
{
    "idActor": "1234",
    "biografia": "subiografia"
}
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idActor reciente creado.
> Es necesario que devuelva los atributos heredados de la clase Persona.

---

## Actualizar un actor

Actualización de un actor en en sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/actores/1234>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
  {
    "biograia": "subiografianueva"
  }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario creado:

```json
{
    "idActor": "1234",
    "biografia": "subiografianueva"
}
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idActor reciente actualizado.
> Es necesario que devuelva los atributos heredados de la clase Persona

---

## Eliminar un actor

Elimina un actor del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/actores/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor
